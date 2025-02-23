package com.candi.animalia.dto.mascota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EditMascotaDTO(
        @NotBlank
        String nombre,
        LocalDate fechaNacimiento,
        String avatar,
        String biografia,
        @NotNull
        UUID razaId,
        @NotNull
        UUID especieId
){
}
