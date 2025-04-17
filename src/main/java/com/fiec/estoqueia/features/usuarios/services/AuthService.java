package com.fiec.estoqueia.features.usuarios.services;

import com.fiec.estoqueia.features.usuarios.business.dtos.LoginRequestDto;
import com.fiec.estoqueia.features.usuarios.business.entities.Usuarios;

public interface AuthService {
    Usuarios signup(LoginRequestDto input);
    Usuarios authenticate(LoginRequestDto input);
}
