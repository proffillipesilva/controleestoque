package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.dtos.LoginRequest;
import com.fiec.estoqueia.business.entities.Usuarios;

import java.util.Optional;

public interface AuthService {
    Usuarios signup(LoginRequest input);
    Usuarios authenticate(LoginRequest input);
}
