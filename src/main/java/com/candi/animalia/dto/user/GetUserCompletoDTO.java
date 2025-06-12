package com.candi.animalia.dto.user;

import com.candi.animalia.dto.mascota.GetListMascotas;
import com.candi.animalia.dto.mascota.GetMascotaDTO;
import com.candi.animalia.dto.mascota.GetMascotaSinUserDTO;
import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
import com.candi.animalia.dto.publicacion.GetPublicacionSinUserDTO;
import com.candi.animalia.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record GetUserCompletoDTO(
        UUID id,
        String username,
        String email,
        LocalDate fechaRegistro,
        Set<String> roles,
        boolean enable,
        List<GetMascotaDTO> mascotaDTOList,
        List<GetPublicacionSinUserDTO> publicacionDTOS,
        String password,
        String verifyPassword

) {
    public static GetUserCompletoDTO of(Usuario usuario){
        return new GetUserCompletoDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRegistrationDate(),
                usuario.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet()),
                usuario.isEnabled(),
              usuario.getMascotaList().stream()
                      .map(m -> GetMascotaDTO.of(m, m.getAvatar()))
                      .collect(Collectors.toList()),
                usuario.getPublicacions().stream()
                        .map(p -> GetPublicacionSinUserDTO.of(p, p.getImage()))
                        .collect(Collectors.toList()),
                usuario.getPassword(),
                usuario.getPassword()
        );
    }
}
