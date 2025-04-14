package com.fiec.estoqueia.business.dtos;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;
}