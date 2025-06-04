package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.UUID;

public record GetPublicacionSinUserDTO(
        UUID id,
        String imageURL,
        String descripcion,
        LocalDate fechaRegistro
) {

    public static GetPublicacionSinUserDTO of(Publicacion publicacion, String url){
        return new GetPublicacionSinUserDTO(
                publicacion.getId(),
                url,
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion()
        );
    }
}
