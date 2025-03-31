package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.LoginRequest;
import com.fiec.estoqueia.business.entities.Usuarios;
import com.fiec.estoqueia.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        Optional<Usuarios> usuario = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (usuario.isPresent()) {
            String token = authService.generateJwtToken(usuario.get().getId().toString(), usuario.get().getEmail());
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    @DeleteMapping("/logout")
    public void deleteUser() {

    }
}