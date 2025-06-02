package com.candi.animalia.dto.user;

import com.candi.animalia.dto.mascota.GetListMascotas;
import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record GetUserDTO(
        UUID id,
        String username,
        String email,
        LocalDate fechaRegistro,
        Set<String> roles,
        boolean enable,
        List<GetListMascotas> mascotaDTOList,
        String password,
        String verifyPassword

) {
    public static GetUserDTO of(Usuario usuario){
        return new GetUserDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRegistrationDate(),
                usuario.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()),
                usuario.isEnabled(),
                GetListMascotas.of2(usuario.getMascotaList()),
                usuario.getPassword(),
                usuario.getPassword()
        );
    }
}
