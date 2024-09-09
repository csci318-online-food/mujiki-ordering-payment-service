package com.csci318.microservice.payment.Services;

import com.csci318.microservice.payment.DTOs.PaymentDTORequest;
import com.csci318.microservice.payment.DTOs.PaymentDTOResponse;

import java.util.List;
import java.util.UUID;

public interface PaymentService {

    List<PaymentDTOResponse> allPaymentFromUser (UUID userId);
    PaymentDTOResponse createPayment(PaymentDTORequest paymentDTORequest);
    PaymentDTOResponse updateBalance(PaymentDTORequest paymentDTORequest, UUID paymentId);
}
