package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.model.Mascota;

import java.time.LocalDate;
import java.util.UUID;

public record GetMascotaSinUserDTO(
        UUID id,
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String avatar,
        GetRazaDTO raza,
        GetEspecieDTO especie
) {

    public static GetMascotaSinUserDTO of(Mascota mascota, String url){
        return new GetMascotaSinUserDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getBiografia(),
                mascota.getFechaNacimiento(),
                url,
                GetRazaDTO.of(mascota.getRaza()),
                GetEspecieDTO.of(mascota.getEspecie())
        );
    }
}

