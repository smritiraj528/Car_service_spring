package com.cars24.csms.data.response;

import com.cars24.csms.data.enums.InvoiceStatus;
import lombok.Data;

@Data
public class CreateInvoiceResponse {
    private int appointment_id;
    private double amount;
    private InvoiceStatus status;

}
