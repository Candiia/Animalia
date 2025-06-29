package com.candi.animalia.repository;

import com.candi.animalia.model.Mascota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MascotaRepository extends  JpaRepository<Mascota, UUID>, JpaSpecificationExecutor<Mascota> {

    @Query("""
            SELECT m
            FROM Mascota m
            ORDER BY m.nombre
            """)
    Page<Mascota> findAllMascota(Pageable pageable);


    @Query("""
            SELECT m
            FROM Mascota m
            LEFT JOIN FETCH m.usuario
            WHERE m.usuario.id = :id
            """)
    Page<Mascota> findByUsuarioIdMascotas(@Param("id") UUID usuarioId, Pageable pageable);


    @Query("SELECT COUNT(m) FROM Mascota m")
    long contarMascotas();


}
