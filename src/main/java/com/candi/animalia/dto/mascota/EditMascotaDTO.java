package com.candi.animalia.dto.mascota;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record EditMascotaDTO(
        @NotBlank(message = "{editMascotaDTO.nombre.notblank}")
        String nombre,
        LocalDate fechaNacimiento,
        String avatar,
        String biografia,
        @NotNull(message = "{editMascotaDTO.razaId.notnull}")
        UUID razaId,
        @NotNull(message = "{editMascotaDTO.especieId.notnull}")
        UUID especieId
){
}
