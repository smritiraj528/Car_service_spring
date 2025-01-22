package com.cars24.csms.Controller;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.response.CreateInvoiceResponse;
import com.cars24.csms.data.response.GetInvoiceResponse;
import com.cars24.csms.services.InvoiceServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;

@RestController
@RequestMapping("/invoice")
@Validated
@Slf4j
@RequiredArgsConstructor
public class InvoiceController {

    //@Autowired
     private final InvoiceServices is;
    //private final InvoiceServices is2;
    @GetMapping("/{appointment_id}")
    public ResponseEntity<GetInvoiceResponse> getInvoiceByAppointmentId(@PathVariable("appointment_id") int appointment_id ) {

        GetInvoiceResponse response = is.getInvoiceByAppointmentId(appointment_id);
        return ResponseEntity.ok(response);
    }



    @PostMapping
    public ResponseEntity<CreateInvoiceResponse> createInvoice(@Valid @RequestBody CreateInvoiceRequest createInvoiceRequest){
        //System.out.println("[createInvoice] createInvoicerequest{}"+createInvoiceRequest);
        log.info("[createInvoice] createInvoiceRequest {} ",createInvoiceRequest);
        CreateInvoiceResponse response=is.createInvoice(createInvoiceRequest);
        return ResponseEntity.ok(response);


    }
    @DeleteMapping("/{appointment_id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable int appointment_id) {
        log.info("[deleteInvoice] Deleting invoice for appointment_id: {}", appointment_id);
        is.deleteInvoice(appointment_id);
        return ResponseEntity.ok("Invoice deleted successfully");
    }


}
