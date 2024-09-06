package com.csci318.microservice.payment.Utils;

import com.csci318.microservice.payment.Repositories.PaymentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInitalizer implements CommandLineRunner {

    private final PaymentRepository paymentRepository;

    public DBInitalizer(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // if (paymentRepository.count() == 0) {
        // }
    }
}
