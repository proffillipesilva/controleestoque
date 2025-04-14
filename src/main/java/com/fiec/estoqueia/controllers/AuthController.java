package com.fiec.estoqueia.controllers;

import com.fiec.estoqueia.business.dtos.LoginRequest;
import com.fiec.estoqueia.business.dtos.LoginResponse;
import com.fiec.estoqueia.business.entities.Usuarios;
import com.fiec.estoqueia.services.AuthService;
import com.fiec.estoqueia.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
public class AuthController {
    private final JwtService jwtService;

    private final AuthService authenticationService;

    public AuthController(JwtService jwtService, AuthService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

//    @PostMapping("/signup")
//    public ResponseEntity<Usuarios> register(@RequestBody LoginRequest registerUsuariosDto) {
//        Usuarios registeredUsuarios = authenticationService.signup(registerUsuariosDto);
//
//        return ResponseEntity.ok(registeredUsuarios);
//    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginUsuariosDto) {
        Usuarios authenticatedUsuarios = authenticationService.authenticate(loginUsuariosDto);

        String jwtToken = jwtService.generateToken(authenticatedUsuarios);

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping("/logout")
    public void deleteUsuarios() {

    }
}
