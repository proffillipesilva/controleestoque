package com.fiec.estoqueia.services;

import com.fiec.estoqueia.business.entities.Usuarios;

import java.util.Optional;

public interface UsuariosService {

    Optional<Usuarios> findUsuariosByEmailAndSenha(String email, String password);
    Optional<Usuarios> findUsuariosByEmail(String email);
}
