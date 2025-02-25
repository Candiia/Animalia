package com.candi.animalia.dto.like;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateLikeDTO(
        @NotNull(message = "{createLikeDTO.publicacionId.notblank}")
        UUID publicacionId
) {
}
