package com.csci318.microservice.payment.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentDTOResponse {
    private UUID id;
    private UUID userId;
    private String bank;
    private String cardNumber;
    private Double balance;
}
