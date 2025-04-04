package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.entities.Usuarios;
import com.fiec.estoqueia.business.repositories.UsuariosRepository;
import com.fiec.estoqueia.services.AuthService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UsuariosRepository usuarioRepository;

    // o secret nao devera ter traços e ter no minimo 512 (use SHA512 generator online)
    private String jwtSecret = "062a569fc4f8e8edb03a5323af481aab46eb0c887ce11427be1c122990493ece62fdd0e26855b057f5100719b55aa44d119e9dcf01e79baa8a1a10d4f1121767";
    private long jwtExpirationMs = 86400000; // 24 hours

    public String generateJwtToken(String userId, String email) {
        return Jwts.builder()
                .setSubject(userId)
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public Optional<Usuarios> authenticateUser(String email, String senha) {
        return usuarioRepository.findByEmailAndSenha(email, senha);
    }
}