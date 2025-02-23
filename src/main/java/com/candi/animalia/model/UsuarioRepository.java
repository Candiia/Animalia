package com.candi.animalia.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

  @Query("""
            SELECT u
            FROM Usuario u
            LEFT JOIN FETCH u.mascotaList
            WHERE u.id = :id
            """)
  Optional<Usuario> buscarConMascotas(@Param("id") UUID id);

  boolean existsByUsername(String nombre);
}