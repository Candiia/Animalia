package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;

public record GetPublicacionDTO(
        String tipo,
        String descripcion,
        LocalDate fechaRegistro,
        GetUserDTO usuario,
        GetMascotaDTO mascotaDTO
) {

    public static GetPublicacionDTO of(Publicacion publicacion){
        return new GetPublicacionDTO(
                publicacion.getTipo(),
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                GetUserDTO.of(publicacion.getUsuario()),
                GetMascotaDTO.of(publicacion.getMascota())
        );
    }
}
