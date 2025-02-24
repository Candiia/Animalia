package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;

public record GetPublicacionEditDTO(
        String imageURL,
        String descripcion,
        LocalDate fechaRegistro,
        GetUserDTO usuario,
        GetMascotaDTO mascotaDTO
) {

    public static GetPublicacionEditDTO of(Publicacion publicacion){
        return new GetPublicacionEditDTO(
                publicacion.getImage(),
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                GetUserDTO.of(publicacion.getUsuario()),
                GetMascotaDTO.of(publicacion.getMascota(), publicacion.getImage())
        );
    }
}
