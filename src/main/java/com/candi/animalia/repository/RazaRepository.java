package com.candi.animalia.repository;

import com.candi.animalia.model.Raza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface RazaRepository extends  JpaRepository<Raza, UUID>, JpaSpecificationExecutor<Raza> {

    @Query("""
            SELECT r
            FROM Raza r
            ORDER BY r.nombre
            """)
    Page<Raza> findAllRaza(Pageable pageable);

    boolean existsByNombre(String nombre);

    @Query("""
            SELECT r
            FROM Raza r
            LEFT JOIN FETCH r.mascotas
            WHERE r.id = :id
            """)
    Optional<Raza> findbyIdMascotas(@Param("id") UUID id);


    @Query("SELECT COUNT(e) FROM Especie e")
    long contarRazas();
}
