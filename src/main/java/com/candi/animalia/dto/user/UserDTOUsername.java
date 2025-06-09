package com.candi.animalia.dto.user;

import com.candi.animalia.model.Usuario;

public record UserDTOUsername(String username) {

    public static UserDTOUsername of(Usuario usuario){
        return new UserDTOUsername(
                usuario.getUsername()
        );
    }

}
