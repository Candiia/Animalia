package com.candi.animalia.dto.raza;

import com.candi.animalia.validation.UniqueNombre;

public record CreateRazaDTO(
        @UniqueNombre
        String nombre
) {
}
