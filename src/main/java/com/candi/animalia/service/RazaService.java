package com.candi.animalia.service;

import com.candi.animalia.dto.raza.CreateRazaDTO;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.RazaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RazaService {

    private final RazaRepository razaRepository;

    public Page<Raza> findAll(Pageable pageable) {
        Page<Raza> result = razaRepository.findAllRaza(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay raza con esos criterios de búsqueda");
        return result;
    }

    public Raza findById(UUID id) {
        return razaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay raza con esa id " + id));

    }

    public Raza save(CreateRazaDTO raza) {
        return razaRepository.save(Raza.builder()
                .nombre(raza.nombre())
                .build());
    }
}
