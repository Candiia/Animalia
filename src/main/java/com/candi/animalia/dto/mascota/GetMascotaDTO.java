package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.UserDTOUsername;
import com.candi.animalia.model.Mascota;

import java.time.LocalDate;
import java.util.UUID;

public record GetMascotaDTO(
        UUID id,
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String avatar,
        GetRazaDTO raza,
        GetEspecieDTO especie,
        UserDTOUsername userDTO
) {

    public static GetMascotaDTO of(Mascota mascota, String url){
        return new GetMascotaDTO(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getBiografia(),
                mascota.getFechaNacimiento(),
                url,
                GetRazaDTO.of(mascota.getRaza()),
                GetEspecieDTO.of(mascota.getEspecie()),
                UserDTOUsername.of(mascota.getUsuario())
        );
    }
}

