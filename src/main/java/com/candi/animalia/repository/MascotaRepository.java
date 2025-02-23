package com.candi.animalia.repository;

import com.candi.animalia.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MascotaRepository extends  JpaRepository<Mascota, UUID> {


}
