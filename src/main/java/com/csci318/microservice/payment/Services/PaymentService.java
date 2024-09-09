package com.csci318.microservice.payment.Services;

import com.csci318.microservice.payment.DTOs.PaymentDTORequest;
import com.csci318.microservice.payment.DTOs.PaymentDTOResponse;

import java.util.UUID;

public interface PaymentService {

    PaymentDTOResponse getPaymentByUserId(UUID userId);
    PaymentDTOResponse createPayment(PaymentDTORequest paymentDTORequest);
}
