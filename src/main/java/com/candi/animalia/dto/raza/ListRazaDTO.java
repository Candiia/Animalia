package com.candi.animalia.dto.raza;

import com.candi.animalia.model.Raza;

import java.util.List;

public record ListRazaDTO(
        long count,
        List<GetRazaDTO> items
) {
    public static ListRazaDTO of(List<Raza> list){
        return new ListRazaDTO(
                list.size(),
                list.stream()
                        .map(GetRazaDTO::of)
                        .toList()
        );
    }
    
}
