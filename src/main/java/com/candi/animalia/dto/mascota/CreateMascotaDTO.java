package com.candi.animalia.dto.mascota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CreateMascotaDTO(
        @NotBlank(message = "{createMascotaDTO.nombre.notblank}")
        String nombre,
        LocalDate fechaNacimiento,
        String biografia,
        @NotNull(message = "{createMascotaDTO.razaId.notnull}")
        UUID razaId,
        @NotNull(message = "{createMascotaDTO.especieId.notnull}")
        UUID especieId
) {

}
