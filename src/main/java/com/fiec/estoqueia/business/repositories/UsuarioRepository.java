package com.fiec.estoqueia.business.repositories;

import com.fiec.estoqueia.business.entities.Usuarios;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuarios, String> {
    Optional<Usuarios> findByEmailAndPassword(String email, String password);
    Optional<Usuarios> findByEmail(String email);
}