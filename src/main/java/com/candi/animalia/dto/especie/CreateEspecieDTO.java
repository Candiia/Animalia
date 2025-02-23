package com.candi.animalia.dto.especie;

import com.candi.animalia.validation.UniqueNombreEspecie;

import java.time.LocalDate;

public record CreateEspecieDTO(
        @UniqueNombreEspecie
        String nombre,
        LocalDate localDate
) {
}
