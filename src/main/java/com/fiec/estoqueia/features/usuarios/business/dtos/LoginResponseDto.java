package com.fiec.estoqueia.features.usuarios.business.dtos;

import lombok.Data;

@Data
public class LoginResponseDto {
    private String token;

    private long expiresIn;
}