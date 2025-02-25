package com.candi.animalia.dto.comentario;
import jakarta.validation.constraints.NotBlank;

public record CreateComentarioDTO(
        @NotBlank(message = "{createComentarioDTO.texto.notblank}")
        String texto
) { }