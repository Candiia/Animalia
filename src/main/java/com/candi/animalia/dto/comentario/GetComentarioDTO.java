package com.candi.animalia.dto.comentario;

import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.dto.user.UserDTOUsername;
import com.candi.animalia.model.Comentario;
import com.candi.animalia.model.Publicacion;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record GetComentarioDTO(
        UUID id,
        String texto,
        LocalDate fechaRealizada,
        UserDTOUsername userDTO
) {

    public static GetComentarioDTO of(Comentario comentario){
        return new GetComentarioDTO(
                comentario.getId(),
                comentario.getComentario(),
                comentario.getFechaRealizada(),
                UserDTOUsername.of(comentario.getUsuario())
        );
    }

    public static List<GetComentarioDTO> of(List<Comentario> comentarios) {
        return comentarios.stream()
                .map(GetComentarioDTO::of)
                .collect(Collectors.toList());
    }
}
