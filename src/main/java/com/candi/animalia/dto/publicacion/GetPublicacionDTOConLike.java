package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.comentario.GetComentarioDTO;
import com.candi.animalia.dto.mascota.GetMascotaDTOName;
import com.candi.animalia.dto.user.UserDTOUsername;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetPublicacionDTOConLike(
        UUID id,
        String imageURL,
        String descripcion,
        LocalDate fechaRegistro,
        long numeroLikes,
        long numeroComentarios,
        List<GetComentarioDTO> comentarioDTOList,
        UserDTOUsername usename,
        boolean hasLike,
        GetMascotaDTOName getMascotaDTOName
) {

    public static GetPublicacionDTOConLike of(Publicacion publicacion, String url, boolean hasLike){
        return new GetPublicacionDTOConLike(
                publicacion.getId(),
                url,
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                publicacion.getLikes().size(),
                publicacion.getComentarios().size(),
                GetComentarioDTO.of(publicacion.getComentarios()),
                UserDTOUsername.of(publicacion.getUsuario()),
                hasLike,
                GetMascotaDTOName.of(publicacion.getMascota())
        );
    }
}
