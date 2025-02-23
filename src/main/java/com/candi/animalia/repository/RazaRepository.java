package com.candi.animalia.repository;

import com.candi.animalia.model.Raza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface RazaRepository extends  JpaRepository<Raza, UUID> {

    @Query("""
            SELECT r
            FROM Raza r
            """)
    Page<Raza> findAllRaza(Pageable pageable);

    boolean existsByNombre(String nombre);
}
