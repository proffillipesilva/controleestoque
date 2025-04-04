package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.entities.Usuarios;
import com.fiec.estoqueia.business.repositories.UsuariosRepository;
import com.fiec.estoqueia.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosServiceImpl implements UsuariosService {


    @Autowired
    UsuariosRepository usuariosRepository;


    public Optional<Usuarios> findUsuariosByEmailAndSenha(String email, String senha) {
        return usuariosRepository.findByEmailAndSenha(email, senha);
    }

    @Override
    public Optional<Usuarios> findUsuariosByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }
}
