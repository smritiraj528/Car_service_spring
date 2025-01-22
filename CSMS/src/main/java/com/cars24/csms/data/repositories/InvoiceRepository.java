package com.cars24.csms.data.repositories;

import com.cars24.csms.data.entities.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Integer> {
    @Query("SELECT i FROM InvoiceEntity i WHERE i.appointment_id = :appointment_id")
    Optional<InvoiceEntity> findByAppointmentIdCustom(int appointment_id);
}

