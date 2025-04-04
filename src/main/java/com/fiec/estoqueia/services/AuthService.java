package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.entities.Usuarios;

import java.util.Optional;

public interface AuthService {
    String generateJwtToken(String userId, String email);
    Optional<Usuarios> authenticateUser(String email, String senha);
}