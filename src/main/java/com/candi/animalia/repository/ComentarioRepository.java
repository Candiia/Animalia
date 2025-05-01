package com.candi.animalia.repository;

import com.candi.animalia.model.Comentario;
import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Raza;
import com.candi.animalia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ComentarioRepository extends JpaRepository<Comentario, UUID>, JpaSpecificationExecutor<Comentario> {

    @Query("""
            SELECT c
            FROM Comentario c
            LEFT JOIN FETCH c.publicacion p
            LEFT JOIN FETCH c.usuario u
            WHERE c.publicacion.id = :id
           """)
    Page<Comentario> findAllByPublicacionId(Pageable pageable, @Param("id") UUID publicacionId);


    Optional<Comentario> findByPublicacionAndUsuario(Publicacion publicacion, Usuario usuario);

    @Query("SELECT COUNT(c) FROM Comentario c")
    long contarComentarios();

}
