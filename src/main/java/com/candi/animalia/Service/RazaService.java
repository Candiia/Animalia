package com.candi.animalia.Service;

import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.RazaInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RazaService {

    private final RazaInterface razaInterface;

    public List<Raza> findAll() {
        List<Raza> result = razaInterface.findAll();
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay raza con esos criterios de búsqueda");
        return result;
    }
}
