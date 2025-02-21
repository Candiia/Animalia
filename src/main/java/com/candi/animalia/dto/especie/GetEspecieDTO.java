package com.candi.animalia.dto.especie;

import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Raza;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record GetEspecieDTO(
        String nombre,
        LocalDate localDate
) {

    public static GetEspecieDTO of(Especie especie){
        return new GetEspecieDTO(
                especie.getNombre(),
                especie.getFechaRegistro()
        );
    }
}
