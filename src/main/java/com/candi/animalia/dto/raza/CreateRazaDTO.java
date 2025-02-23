package com.candi.animalia.dto.raza;

import com.candi.animalia.validation.UniqueNombreRaza;

public record CreateRazaDTO(
        @UniqueNombreRaza
        String nombre
) {
}
