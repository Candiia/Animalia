package com.candi.animalia.dto.mascota;

import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Raza;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

public record CreateMascotaDTO(
        @NotBlank
        String nombre,
        LocalDate fechaNacimiento,
        String biografia,
        @NotNull
        UUID razaId,
        @NotNull
        UUID especieId
) {

}
