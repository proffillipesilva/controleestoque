package com.fiec.estoqueia.business.repositories;



import com.fiec.estoqueia.business.entities.Usuarios;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends MongoRepository<Usuarios, ObjectId> {
    Optional<Usuarios> findByEmailAndSenha(String email, String senha);
    Optional<Usuarios> findByEmail(String email);
}