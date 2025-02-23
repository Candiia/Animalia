package com.candi.animalia.repository;

import com.candi.animalia.model.Mascota;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface MascotaRepository extends  JpaRepository<Mascota, UUID> {

    @Query("""
            SELECT m
            FROM Mascota m
            """)
    Page<Mascota> findAllMascota(Pageable pageable);


}
