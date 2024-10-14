package com.csci318.microservice.payment.Domain.Entities;

import com.csci318.microservice.payment.Domain.Relations.User;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id")
    @ManyToOne(targetEntity = User.class)
    private UUID userId;

    @Column(name = "holder_name")
    private String holderName; // holder_name

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "balance")
    private Double balance;
}
