package com.csci318.microservice.payment.Repositories;

import com.csci318.microservice.payment.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {

    @Query("SELECT p FROM Payment p WHERE p.userId = :userId")
    Payment findByUserId(UUID userId);

    @Query("SELECT p FROM Payment p WHERE p.userId = :userId")
    List<Payment> findAllByUserId(UUID userId);
}
