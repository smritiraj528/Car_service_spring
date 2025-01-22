package com.cars24.csms.data.req;

import com.cars24.csms.data.enums.InvoiceStatus;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Valid
@Data
public class CreateInvoiceRequest {
    @Valid

    @Min(value=1,message="must be a positive number")
    @NotNull

    private int appointment_id;
    @Valid
    @Min(value=1,message="invalid amount")

    private double amount;

    private InvoiceStatus status;
}
