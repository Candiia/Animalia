package com.candi.animalia.dto.especie;

import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Raza;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

public record GetEspecieDTO(
        UUID id,
        String nombre,
        LocalDate localDate
) {

    public static GetEspecieDTO of(Especie especie){
        return new GetEspecieDTO(
                especie.getId(),
                especie.getNombre(),
                especie.getFechaRegistro()
        );
    }
}
