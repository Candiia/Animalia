package com.candi.animalia.repository;

import com.candi.animalia.model.Raza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface RazaInterface extends JpaRepository<Raza, UUID> {


    List<Raza> findAllMascotas();
}
