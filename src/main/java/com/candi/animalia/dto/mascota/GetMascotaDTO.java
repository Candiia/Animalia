package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Mascota;

import java.time.LocalDate;

public record GetMascotaDTO(
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String avatar,
        GetRazaDTO raza,
        GetEspecieDTO especie,
        GetUserDTO userDTO
) {

    public static GetMascotaDTO of(Mascota mascota){
        return new GetMascotaDTO(
                mascota.getNombre(),
                mascota.getBiografia(),
                mascota.getFechaNacimiento(),
                mascota.getAvatar(),
                mascota.getRaza() != null ? GetRazaDTO.of(mascota.getRaza()) : null,
                mascota.getEspecie() != null ? GetEspecieDTO.of(mascota.getEspecie()) : null,
                GetUserDTO.of(mascota.getUsuario())
        );
    }
}

