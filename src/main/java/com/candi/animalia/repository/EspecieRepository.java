package com.candi.animalia.repository;

import com.candi.animalia.model.Especie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface EspecieRepository extends  JpaRepository<Especie, UUID>, JpaSpecificationExecutor<Especie> {

    @Query("""
            SELECT e
            FROM Especie e
            """)
    Page<Especie> findAllEspecie(Pageable pageable);

    boolean existsByNombre(String nombre);

    @Query("""
            SELECT e
            FROM Especie e
            LEFT JOIN FETCH e.mascotas
            WHERE e.id = :id
            """)
    Optional<Especie> findbyIdMascotas(@Param("id") UUID id);


    @Query("SELECT COUNT(e) FROM Especie e")
    long contarEspecies();

}
