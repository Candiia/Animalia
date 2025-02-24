package com.candi.animalia.repository;

import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface PublicacionRepository extends JpaRepository<Publicacion, UUID> {


    /*@Query("""
            SELECT p
            FROM Publicacion p
            LEFT JOIN FETCH p.usuario
            WHERE p.usuario.id = :id
            """)
    Page<Publicacion> findAllPublicacionByMe(@Param("id") UUID usuarioId, Pageable pageable);*/

    @Query("""
            SELECT p
            FROM Publicacion p
            """)
    Page<Publicacion> findAllPublicacion(Pageable pageable);

    @Query(""" 
            SELECT u
            FROM Usuario u
            LEFT JOIN FETCH u.publicacions
            WHERE u.id = :id
            """)
    Optional<Usuario> findByIdConPublicacions(@Param("id") UUID id);


}
