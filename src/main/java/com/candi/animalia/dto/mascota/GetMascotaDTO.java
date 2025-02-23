package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.mascota.Mascota;

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
                GetRazaDTO.of(mascota.getRaza()),
                GetEspecieDTO.of(mascota.getEspecie()),
                GetUserDTO.of(mascota.getUsuario())
        );
    }
}
