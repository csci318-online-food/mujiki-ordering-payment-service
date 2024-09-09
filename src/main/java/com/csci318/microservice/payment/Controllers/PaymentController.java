package com.csci318.microservice.payment.Controllers;

import com.csci318.microservice.payment.DTOs.PaymentDTORequest;
import com.csci318.microservice.payment.DTOs.PaymentDTOResponse;
import com.csci318.microservice.payment.Services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("${api.endpoint.base-url}/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<PaymentDTOResponse> createPayment(@RequestBody PaymentDTORequest paymentDTORequest) {
        PaymentDTOResponse paymentDTOResponse = paymentService.createPayment(paymentDTORequest);
        return ResponseEntity.ok(paymentDTOResponse);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PaymentDTOResponse>> allPaymentFromUser(@PathVariable UUID userId) {
        List<PaymentDTOResponse> paymentDTOResponses = paymentService.allPaymentFromUser(userId);
        return ResponseEntity.ok(paymentDTOResponses);
    }

    @PutMapping("/update-balance/{paymentId}")
    public ResponseEntity<PaymentDTOResponse> updateBalance(@RequestBody PaymentDTORequest paymentDTORequest, @PathVariable UUID paymentId) {
        PaymentDTOResponse paymentDTOResponse = paymentService.updateBalance(paymentDTORequest, paymentId);
        return ResponseEntity.ok(paymentDTOResponse);
    }
}
