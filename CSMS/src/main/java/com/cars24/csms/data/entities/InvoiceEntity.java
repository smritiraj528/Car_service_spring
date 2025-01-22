package com.cars24.csms.data.entities;

import com.cars24.csms.data.enums.InvoiceStatus;
import jakarta.persistence.*;

import lombok.Data;
@Data



@Table(name = "invoices")
@Entity
public class InvoiceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column(name="invoice_id")
    private int id;
    @jakarta.persistence.Column(name="appointment_id")

    private int appointment_id;
    @Column(name="amount")
    private double amount;
    @Column(name="payment_status")
    @Enumerated(EnumType.STRING)
    private InvoiceStatus status;

}
