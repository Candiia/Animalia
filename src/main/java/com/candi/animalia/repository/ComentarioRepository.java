package com.candi.animalia.repository;

import com.candi.animalia.model.Comentario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<Comentario, UUID> {

    @Query("""
            SELECT c
            FROM Comentario c
            LEFT JOIN FETCH c.publicacion p
            LEFT JOIN FETCH c.usuario u
            WHERE c.publicacion.id = :id
           """)
    Page<Comentario> findAllByPublicacionId(Pageable pageable, @Param("id") UUID publicacionId);
}
