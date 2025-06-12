package com.candi.animalia.dto.mascota;

import com.candi.animalia.model.Mascota;

public record GetMascotaDTOName(
        String nombre
) {

    public static GetMascotaDTOName of(Mascota mascota){
        return new GetMascotaDTOName(
                mascota.getNombre()
        );
    }
}

