package com.candi.animalia.dto.mascota;

import com.candi.animalia.model.Mascota;

import java.util.List;
import java.util.stream.Collectors;

public record GetListMascotas(
        String nombre
) {
    public static GetListMascotas of(Mascota mascota) {
        return new GetListMascotas(
                mascota.getNombre()
        );
    }

    public static List<GetListMascotas> of2(List<Mascota> mascotaList) {
        return mascotaList.stream()
                .map(GetListMascotas::of)
                .collect(Collectors.toList());
    }

}
