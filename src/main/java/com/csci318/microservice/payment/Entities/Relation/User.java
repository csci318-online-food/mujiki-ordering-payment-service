package com.csci318.microservice.payment.Entities.Relation;

import com.csci318.microservice.payment.Constants.HttpStatus.Roles;

import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Roles role;
}
