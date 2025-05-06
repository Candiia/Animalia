package com.candi.animalia.dto.admin;
import java.time.YearMonth;

public record PublicacionesPorMesDTO(
        YearMonth mes,
        Long cantidad
) {
}
