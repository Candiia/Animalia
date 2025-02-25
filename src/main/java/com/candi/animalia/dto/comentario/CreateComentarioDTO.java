        package com.candi.animalia.dto.comentario;

        import jakarta.validation.constraints.NotBlank;

        public record CreateComentarioDTO(
               @NotBlank(message = "El comentario no puede estar vacio")
               String texto
        ) {
        }