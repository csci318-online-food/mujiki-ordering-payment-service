package com.csci318.microservice.payment.Mappers;

import com.csci318.microservice.payment.DTOs.PaymentDTORequest;
import com.csci318.microservice.payment.DTOs.PaymentDTOResponse;
import com.csci318.microservice.payment.Entities.Payment;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaymentMapper implements Mapper<Payment, PaymentDTOResponse, PaymentDTOResponse> {
    @Override
    public PaymentDTOResponse toDtos(Payment entity) {
        PaymentDTOResponse dto = new PaymentDTOResponse();
        dto.setId(entity.getId());
        dto.setUserId(entity.getUserId());
        dto.setHolderName(entity.getHolderName());
        dto.setCardNumber(entity.getCardNumber());
        dto.setBalance(entity.getBalance());
        return dto;
    }

    @Override
    public Payment toEntities(PaymentDTOResponse dto) {
        Payment entity = new Payment();
        entity.setUserId(dto.getUserId());
        entity.setHolderName(dto.getHolderName());
        entity.setCardNumber(dto.getCardNumber());
        entity.setBalance(dto.getBalance());
        return entity;
    }

    @Override
    public List<PaymentDTOResponse> toDtos(List<Payment> payments) {
        return payments.stream().map(this::toDtos).toList();
    }

    @Override
    public List<Payment> toEntities(List<PaymentDTOResponse> dtos) {
        return dtos.stream().map(this::toEntities).toList();
    }
}
