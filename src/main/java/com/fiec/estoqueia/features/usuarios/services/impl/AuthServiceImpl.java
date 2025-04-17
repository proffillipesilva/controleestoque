package com.fiec.estoqueia.features.usuarios.services.impl;

import com.fiec.estoqueia.features.usuarios.business.dtos.LoginRequestDto;
import com.fiec.estoqueia.features.usuarios.business.entities.Usuarios;
import com.fiec.estoqueia.features.usuarios.business.repositories.UsuarioRepository;
import com.fiec.estoqueia.features.usuarios.services.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UsuarioRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public AuthServiceImpl(
            UsuarioRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Usuarios signup(LoginRequestDto input) {
        Usuarios user = Usuarios.builder()
                .email(input.getEmail())
                .password(passwordEncoder.encode(input.getPassword()))
                .build();
        return userRepository.save(user);
    }

    public Usuarios authenticate(LoginRequestDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }
}