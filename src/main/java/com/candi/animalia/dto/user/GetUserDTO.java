package com.candi.animalia.dto.user;

import com.candi.animalia.model.Usuario;

import java.time.LocalDate;

public record GetUserDTO(
        String username,
        String email,
        LocalDate fechaRegistro
) {
    public static GetUserDTO of(Usuario usuario){
        return new GetUserDTO(
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRegistrationDate()
        );
    }
}
