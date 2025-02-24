package com.candi.animalia.dto.like;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateLikeDTO(
        @NotNull(message = "El ID de la publicación no puede ser nulo")
        UUID publicacionId
) {
}
