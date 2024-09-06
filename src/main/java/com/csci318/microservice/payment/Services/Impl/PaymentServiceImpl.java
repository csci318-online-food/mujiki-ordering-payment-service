package com.csci318.microservice.payment.Services.Impl;

import com.csci318.microservice.payment.Repositories.PaymentRepository;
import com.csci318.microservice.payment.Services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    private final RestTemplate restTemplate;
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Value("${address.url.service}")
    private String ADDRESS_URL;

    public PaymentServiceImpl(RestTemplate restTemplate, PaymentRepository paymentRepository, ApplicationEventPublisher eventPublisher) {
        this.restTemplate = restTemplate;
        this.paymentRepository = paymentRepository;
        this.eventPublisher = eventPublisher;
    }
}
