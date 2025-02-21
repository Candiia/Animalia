package com.candi.animalia.service;

import com.candi.animalia.dto.raza.CreateRazaDTO;
import com.candi.animalia.dto.raza.EditRazaDTO;
import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.EspecieRepository;
import com.candi.animalia.repository.RazaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

}
