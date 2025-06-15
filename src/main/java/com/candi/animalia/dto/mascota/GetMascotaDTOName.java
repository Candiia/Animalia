package com.candi.animalia.dto.mascota;

import com.candi.animalia.model.Mascota;

import java.util.UUID;

public record GetMascotaDTOName(
        UUID id,
        String nombre
) {

    public static GetMascotaDTOName of(Mascota mascota){
        return new GetMascotaDTOName(
                mascota.getId(),
                mascota.getNombre()
        );
    }
}

