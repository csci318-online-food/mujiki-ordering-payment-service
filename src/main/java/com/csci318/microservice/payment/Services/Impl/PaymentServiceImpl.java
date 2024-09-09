package com.csci318.microservice.payment.Services.Impl;

import com.csci318.microservice.payment.DTOs.PaymentDTORequest;
import com.csci318.microservice.payment.DTOs.PaymentDTOResponse;
import com.csci318.microservice.payment.Entities.Payment;
import com.csci318.microservice.payment.Mappers.PaymentMapper;
import com.csci318.microservice.payment.Repositories.PaymentRepository;
import com.csci318.microservice.payment.Services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.csci318.microservice.payment.Entities.Relation.User;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    private final RestTemplate restTemplate;
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;
    private final PaymentMapper paymentMapper;

    @Value("${user.url.service}")
    private String USER_URL;

    public PaymentServiceImpl(RestTemplate restTemplate, PaymentRepository paymentRepository, ApplicationEventPublisher eventPublisher, PaymentMapper paymentMapper) {
        this.restTemplate = restTemplate;
        this.paymentRepository = paymentRepository;
        this.eventPublisher = eventPublisher;
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentDTOResponse> allPaymentFromUser (UUID userId) {
        List<Payment> payments = this.paymentRepository.findAllByUserId(userId);
        return this.paymentMapper.toDtos(payments);
    }

    @Override
    public PaymentDTOResponse createPayment(PaymentDTORequest paymentDTORequest) {
        User user = restTemplate.getForObject(USER_URL + "/findById/" + paymentDTORequest.getUserId(), User.class);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        try {
            Payment payment = new Payment();
            payment.setUserId(paymentDTORequest.getUserId());
            payment.setBank(paymentDTORequest.getBank());
            payment.setCardNumber(paymentDTORequest.getCardNumber());

            // Generate a random balance
            Random random = new Random();
            double randomBalance = 1000 + (10000 - 100) * random.nextDouble();
            payment.setBalance(randomBalance);

            this.paymentRepository.save(payment);
            return this.paymentMapper.toDtos(payment);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create payment");
        }
    }

    @Override
    public PaymentDTOResponse updateBalance(PaymentDTORequest paymentDTORequest, UUID paymentId) {
        Payment payment = this.paymentRepository.findById(paymentId)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
        payment.setBalance(paymentDTORequest.getBalance());
        this.paymentRepository.save(payment);
        return this.paymentMapper.toDtos(payment);
    }
}
