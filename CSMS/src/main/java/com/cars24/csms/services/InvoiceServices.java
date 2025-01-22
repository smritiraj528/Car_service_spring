package com.cars24.csms.services;

import com.cars24.csms.data.req.CreateInvoiceRequest;
import com.cars24.csms.data.response.CreateInvoiceResponse;
import com.cars24.csms.data.response.GetInvoiceResponse;
import org.springframework.stereotype.Service;

@Service
public interface InvoiceServices {
    public CreateInvoiceResponse createInvoice(CreateInvoiceRequest createInvoiceRequest);
    public GetInvoiceResponse getInvoiceByAppointmentId(int appointment_id);
    void deleteInvoice(int appointment_id);
}
