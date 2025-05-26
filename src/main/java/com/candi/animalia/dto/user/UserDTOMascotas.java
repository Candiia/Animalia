package com.candi.animalia.dto.user;

import com.candi.animalia.dto.mascota.GetListMascotas;
import com.candi.animalia.model.Usuario;

import java.util.stream.Collectors;

public record UserDTOMascotas(String username) {

    public static UserDTOMascotas of(Usuario usuario){
        return new UserDTOMascotas(
                usuario.getUsername()
        );
    }

}
