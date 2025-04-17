package com.fiec.estoqueia.features.usuarios.business.dtos;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String email;
    private String password;

    // Constructors, Getters, Setters (Omitted for brevity)
}