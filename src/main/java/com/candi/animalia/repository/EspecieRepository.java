package com.candi.animalia.repository;

import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Raza;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface EspecieRepository extends  JpaRepository<Especie, UUID> {

    @Query(value = "SELECT e FROM Especie e")
    Page<Especie> findAllEspecie(Pageable pageable);

}
