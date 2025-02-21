package com.candi.animalia.service;

import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.RazaInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RazaService {

    private final RazaInterface razaInterface;

    public Page<Raza> findAll(Pageable pageable) {
        Page<Raza> result = razaInterface.findAllRaza(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay raza con esos criterios de búsqueda");
        return result;
    }
}
