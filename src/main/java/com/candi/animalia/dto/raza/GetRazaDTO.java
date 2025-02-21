package com.candi.animalia.dto.raza;

import com.candi.animalia.model.Raza;
import jakarta.validation.constraints.NotBlank;

public record GetRazaDTO(
        @NotBlank
        String nombre
) {

    public static GetRazaDTO of(Raza raza){
        return new GetRazaDTO(
                raza.getNombre()
        );
    }
}
