package com.cars24.csms.services.Impl;

import com.cars24.csms.data.dao.InvoiceDao;
import com.cars24.csms.data.dao.impl.InvoiceDaoImpl;
import com.cars24.csms.data.entities.InvoiceEntity;
import com.cars24.csms.data.repositories.InvoiceRepository;
import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.response.CreateInvoiceResponse;
import com.cars24.csms.data.response.GetInvoiceResponse;
import com.cars24.csms.services.InvoiceServices;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceServices {
    //@Autowired

    private final InvoiceDao idi;
   // private final InvoiceDao idly;
    //private final InvoiceRepository invoiceRepository;

    @Override
    @Transactional

    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest createInvoiceRequest) {
        int invoiceId = idi.createInvoice(createInvoiceRequest);

        // Construct and return the response
        CreateInvoiceResponse response = new CreateInvoiceResponse();
        //CreateInvoiceResponse response = new CreateInvoiceResponse();
        response.setAppointment_id(createInvoiceRequest.getAppointment_id());
        response.setAmount(createInvoiceRequest.getAmount());
        response.setStatus(createInvoiceRequest.getStatus());
        return response;
        //System.out.println(invoiceId);
    }
    public GetInvoiceResponse getInvoiceByAppointmentId(int appointment_id) {
        // Fetch the InvoiceEntity from the DAO by appointment_id
        Optional<GetInvoiceResponse> invoiceEntity = idi.getInvoiceByAppointmentId(appointment_id);

        // Construct and return the response
        GetInvoiceResponse response = new GetInvoiceResponse();

        // Check if the invoice exists in the Optional
        if (invoiceEntity.isPresent()) {
            // Retrieve the actual entity from Optional
            GetInvoiceResponse entity = invoiceEntity.get();

            // Set values using the .set() methods
            response.setAmount(entity.getAmount());
            response.setStatus(entity.getStatus());
            //response.setAppointment_id(entity.getAppointmentId());  // Assuming you have the appointmentId in the entity

        } else {
            // Handle the case where no invoice is found (you can return null or throw an exception)
            throw new IllegalArgumentException("No invoice found for appointment ID: " + appointment_id);
        }

        return response;
    }
    @Override
    public void deleteInvoice(int appointment_id) {
        idi.deleteInvoiceByAppointmentId(appointment_id);
    }


}
