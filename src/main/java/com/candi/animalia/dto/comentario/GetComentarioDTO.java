package com.candi.animalia.dto.comentario;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Comentario;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.UUID;

public record GetComentarioDTO(
        UUID id,
        String texto,
        LocalDate fechaRealizada,
        GetUserDTO userDTO
) {

    public static GetComentarioDTO of(Comentario comentario){
        return new GetComentarioDTO(
                comentario.getId(),
                comentario.getComentario(),
                comentario.getFechaRealizada(),
                GetUserDTO.of(comentario.getUsuario())

        );
    }
}
