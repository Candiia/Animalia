package com.candi.animalia.service;

import com.candi.animalia.model.mascota.Mascota;
import com.candi.animalia.repository.MascotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    public Page<Mascota> findAll(Pageable pageable) {
        Page<Mascota> result = mascotaRepository.findAllMascota(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay mascota con esos criterios de búsqueda");
        return result;
    }

}
