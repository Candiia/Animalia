package com.candi.animalia.repository;

import com.candi.animalia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID>, JpaSpecificationExecutor<Usuario> {

  @Query("""
            SELECT u
            FROM Usuario u
            LEFT JOIN FETCH u.mascotaList
            WHERE u.id = :id
            
            """)
  Usuario buscarConMascotas(@Param("id") UUID id);

  boolean existsByUsername(String nombre);

  Optional<Usuario> findFirstByUsername(String username);

  Optional<Usuario> findByActivationToken(String activationToken);

  @Query("""
            SELECT u
            FROM Usuario u
            order by u.username
            """)
  Page<Usuario> findAllUsuario(Pageable pageable);

  @Query("SELECT COUNT(u) FROM Usuario u WHERE u.enabled = true")
  long contarUsuariosActivos();

  @Query("""
            SELECT u
            FROM Usuario u
            LEFT JOIN FETCH u.mascotaList
            WHERE u.id = :id
            """)
  Optional<Usuario> findByMascota(@Param("id") UUID id);
}