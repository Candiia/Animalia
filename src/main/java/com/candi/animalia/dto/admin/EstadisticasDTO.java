package com.candi.animalia.dto.admin;

public record EstadisticasDTO(
        long numUser,
        long numMascotas,
        long numEspecies,
        long numRazas,
        long numLikes,
        long numComentarios
) {
}
