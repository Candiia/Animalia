package com.candi.animalia.dto.like;

import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
import com.candi.animalia.dto.user.GetUserDTO;
import com.candi.animalia.model.Like;


import java.time.LocalDate;

public record GetLikeDTO(
        LocalDate fechaRealizada,
        GetPublicacionDTO publicacionDTO,
        GetUserDTO userDTO
) {

    public static GetLikeDTO of(Like like){
        return new GetLikeDTO(
                like.getFechaRealizada(),
                GetPublicacionDTO.of(like.getPublicacion(), like.getPublicacion().getImage()),
                GetUserDTO.of(like.getUsuario())
        );
    }
}
