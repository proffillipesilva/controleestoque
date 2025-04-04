package com.fiec.estoqueia.business.dtos;

import lombok.Data;

@Data
public class LoginRequestDto {
    String email;
    String senha;
}
