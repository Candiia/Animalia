package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.dto.user.UserDTOMascotas;
import com.candi.animalia.model.Mascota;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetMascotaDTO(
        UUID id,
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String avatar,
        GetRazaDTO raza,
        GetEspecieDTO especie,
        UserDTOMascotas userDTO
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
                UserDTOMascotas.of(mascota.getUsuario())
        );
    }
}

