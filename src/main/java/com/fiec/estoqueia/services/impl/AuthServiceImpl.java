package com.fiec.estoqueia.services.impl;

import com.fiec.estoqueia.business.entities.Usuarios;
import com.fiec.estoqueia.business.repositories.UsuarioRepository;
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
    private UsuarioRepository usuarioRepository;

    // o secret nao devera ter traços e ter no minimo 512 (use SHA512 generator online)
    private String jwtSecret = "fbb93a883073bc7225c20221b08e806cde17b642bfc01b9dc50158e0793c9de188501d8e472166ee0672203a5d0108bb74d9f4ff6f5e2af4a62671944f38ed65"; // Store securely!
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

    public Optional<Usuarios> authenticateUser(String email, String password) {
        return usuarioRepository.findByEmailAndPassword(email, password);
    }
}
