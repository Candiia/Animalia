package com.candi.animalia.repository;

import com.candi.animalia.model.Like;
import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, UUID> {


    @Query("""
            SELECT l
            FROM Like l
            LEFT JOIN FETCH l.usuario
            WHERE l.usuario.id = :id
            """)
    Page<Like> findAllLikeByUser(@Param("id") UUID usuarioId, Pageable pageable);


    boolean existsByPublicacionAndUsuario(Publicacion publicacion, Usuario usuario);

    Optional<Like> findByPublicacionAndUsuario(Publicacion publicacion, Usuario usuario);
}
