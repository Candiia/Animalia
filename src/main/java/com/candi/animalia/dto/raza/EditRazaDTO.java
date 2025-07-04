package com.candi.animalia.dto.raza;

import com.candi.animalia.model.Raza;
import com.candi.animalia.validation.UniqueNombreRaza;

public record EditRazaDTO(
        @UniqueNombreRaza
        String nombre
){
    public static EditRazaDTO of(Raza raza){
        return new EditRazaDTO(
                raza.getNombre()
        );
    };
}
