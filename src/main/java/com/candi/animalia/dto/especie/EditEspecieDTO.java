package com.candi.animalia.dto.especie;

import com.candi.animalia.model.Especie;

import com.candi.animalia.validation.UniqueNombreEspecie;

public record EditEspecieDTO(
        @UniqueNombreEspecie
        String nombre
){
    public static EditEspecieDTO of(Especie especie){
        return new EditEspecieDTO(
                especie.getNombre()
        );
    };
}
