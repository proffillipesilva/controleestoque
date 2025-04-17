package com.fiec.estoqueia.features.usuarios.controllers;

import com.fiec.estoqueia.features.usuarios.business.dtos.LoginRequestDto;
import com.fiec.estoqueia.features.usuarios.business.dtos.LoginResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AuthController {

    @PostMapping("/login")
    ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginUsuariosDto);

    @DeleteMapping("/logout")
    void deleteUsuarios();
}
