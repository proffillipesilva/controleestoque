package com.fiec.estoqueia.features.usuarios.controllers.impl;

import com.fiec.estoqueia.features.usuarios.business.dtos.LoginRequestDto;
import com.fiec.estoqueia.features.usuarios.business.dtos.LoginResponseDto;
import com.fiec.estoqueia.features.usuarios.business.entities.Usuarios;
import com.fiec.estoqueia.features.usuarios.controllers.AuthController;
import com.fiec.estoqueia.features.usuarios.services.AuthService;
import com.fiec.estoqueia.services.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/auth")
@RestController
public class AuthControllerImpl implements AuthController {
    private final JwtService jwtService;

    private final AuthService authenticationService;

    public AuthControllerImpl(JwtService jwtService, AuthService authenticationService) {
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
    public ResponseEntity<LoginResponseDto> authenticate(@RequestBody LoginRequestDto loginUsuariosDto) {
        Usuarios authenticatedUsuarios = authenticationService.authenticate(loginUsuariosDto);

        String jwtToken = jwtService.generateToken(authenticatedUsuarios);

        LoginResponseDto loginResponse = new LoginResponseDto();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }

    @DeleteMapping("/logout")
    public void deleteUsuarios() {

    }
}
