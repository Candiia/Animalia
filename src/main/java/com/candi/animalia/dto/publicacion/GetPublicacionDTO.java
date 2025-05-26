package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.UUID;

public record GetPublicacionDTO(
        UUID id,
        String imageURL,
        String descripcion,
        LocalDate fechaRegistro,
        GetUserDTO usuario,
        GetMascotaDTO mascotaDTO
) {

    public static GetPublicacionDTO of(Publicacion publicacion, String url){
        return new GetPublicacionDTO(
                publicacion.getId(),
                url,
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                GetUserDTO.of(publicacion.getUsuario()),
                GetMascotaDTO.of(publicacion.getMascota(), publicacion.getImage())
        );
    }
}
