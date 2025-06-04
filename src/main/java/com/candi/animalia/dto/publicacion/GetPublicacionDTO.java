package com.candi.animalia.dto.publicacion;

import com.candi.animalia.dto.comentario.GetComentarioDTO;
import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.dto.user.UserDTOUsername;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetPublicacionDTO(
        UUID id,
        String imageURL,
        String descripcion,
        LocalDate fechaRegistro,
        long numeroLikes,
        long numeroComentarios,
        List<GetComentarioDTO> comentarioDTOList,
        UserDTOUsername usename
) {

    public static GetPublicacionDTO of(Publicacion publicacion, String url){
        return new GetPublicacionDTO(
                publicacion.getId(),
                url,
                publicacion.getDescripcion(),
                publicacion.getFechaPublicacion(),
                publicacion.getLikes().size(),
                publicacion.getComentarios().size(),
                GetComentarioDTO.of(publicacion.getComentarios()),
                UserDTOUsername.of(publicacion.getUsuario())
        );
    }
}
