package com.cars24.csms.data.dao.impl;

import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.response.GetInvoiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

//import static com.cars24.csms.data.enums.InvoiceStatus.UNPAID;
@Service
@RequiredArgsConstructor
public class InvoiceDaoImpl implements InvoiceDao  {
    //@Autowired
     private final InvoiceRepository ir;
     //private final InvoiceRepository ir2;
    @Override
    public int createInvoice(CreateInvoiceRequest createInvoiceRequest) {

        InvoiceEntity ie=new InvoiceEntity();
        //InvoiceRepository ir;
        //ie.setId(0);
        ie.setAppointment_id(createInvoiceRequest.getAppointment_id());
        ie.setAmount(createInvoiceRequest.getAmount());
        ie.setStatus(createInvoiceRequest.getStatus());
        ir.save(ie);

        return 0;
    }

    @Override
    public Optional<GetInvoiceResponse> getInvoiceByAppointmentId(int appointment_id) {
        // Fetch the InvoiceEntity using repository and map it directly to GetInvoiceResponse
        return ir.findByAppointmentIdCustom(appointment_id)
                .map(invoiceEntity -> {
                    GetInvoiceResponse response = new GetInvoiceResponse();
                    response.setAmount(invoiceEntity.getAmount());
                    response.setStatus(invoiceEntity.getStatus());
                    return response;
                });
    }
    @Override
    public void deleteInvoiceByAppointmentId(int appointment_id) {
        // Find the invoice by appointment_id
        InvoiceEntity invoiceEntity = ir.findByAppointmentIdCustom(appointment_id)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found for appointment id: " + appointment_id));

        ir.delete(invoiceEntity);  // Delete the invoice entity
    }
}
