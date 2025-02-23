package com.candi.animalia.service;

import com.candi.animalia.dto.especie.CreateEspecieDTO;
import com.candi.animalia.dto.especie.EditEspecieDTO;
import com.candi.animalia.dto.raza.EditRazaDTO;
import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.EspecieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EspecieService {

    private final EspecieRepository especieRepository;

    public Page<Especie> findAll(Pageable pageable) {
        Page<Especie> result = especieRepository.findAllEspecie(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay especie con esos criterios de búsqueda");
        return result;
    }

    public Especie findById(UUID id) {
        return especieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay especie con esa id " + id));

    }

    public Especie save(CreateEspecieDTO especieDTO) {
        return especieRepository
                .save(Especie.builder()
                        .fechaRegistro(LocalDate.now())
                        .nombre(especieDTO.nombre())
                        .build());
    }


    public Especie edit(EditEspecieDTO especieDTO, UUID id) {
        return especieRepository.findById(id)
                .map(old -> {
                    old.setNombre(especieDTO.nombre());
                    return especieRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay especie con esa id " + id));
    }


}
