package com.candi.animalia.dto.user;

import com.candi.animalia.model.Usuario;

import java.util.UUID;

public record UserDTOUsernameYId(String username, UUID id) {

    public static UserDTOUsernameYId of(Usuario usuario){
        return new UserDTOUsernameYId(
                usuario.getUsername(),
                usuario.getId()
        );
    }

}
