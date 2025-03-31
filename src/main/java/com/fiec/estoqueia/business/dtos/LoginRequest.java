package com.fiec.estoqueia.business.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;

    // Constructors, Getters, Setters (Omitted for brevity)
}