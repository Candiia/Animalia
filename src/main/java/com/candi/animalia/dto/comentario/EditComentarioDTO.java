package com.candi.animalia.dto.comentario;

import com.candi.animalia.model.Comentario;
import jakarta.validation.constraints.NotBlank;

public record EditComentarioDTO(
        @NotBlank(message = "No puede estar vacío el comentario")
        String comentario
){
    public static EditComentarioDTO of(Comentario comentario){
        return new EditComentarioDTO(
                comentario.getComentario()
        );
    };
}
