package com.candi.animalia.repository;

import com.candi.animalia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Usuario, UUID> {

    Optional<Usuario> findFirstByUsername(String username);

    Optional<Usuario> findByActivationToken(String activationToken);

    @Query("""
            SELECT u
            FROM Usuario u
            """)
    Page<Usuario> findAllUsuario(Pageable pageable);

}
