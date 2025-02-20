package com.candi.animalia.dto.raza;

import com.candi.animalia.model.Raza;

public record GetRazaDTO(
        String nombre
) {

    public static GetRazaDTO of(Raza raza){
        return new GetRazaDTO(
                raza.getNombre()
        );
    }
}
