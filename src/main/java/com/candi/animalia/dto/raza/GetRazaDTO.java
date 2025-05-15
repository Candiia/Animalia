package com.candi.animalia.dto.raza;

import com.candi.animalia.model.Raza;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record GetRazaDTO(
        UUID id,
        String nombre
) {

    public static GetRazaDTO of(Raza raza){
        return new GetRazaDTO(
                raza.getId(),
                raza.getNombre()
        );
    }
}
