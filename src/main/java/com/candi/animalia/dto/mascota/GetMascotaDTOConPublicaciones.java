package com.candi.animalia.dto.mascota;

import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.publicacion.GetPublicacionDTOConLike;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.UserDTOUsername;
import com.candi.animalia.dto.user.UserDTOUsernameYId;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Usuario;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public record GetMascotaDTOConPublicaciones(
        UUID id,
        String nombre,
        String biografia,
        LocalDate fechaNacimiento,
        String avatar,
        GetRazaDTO raza,
        GetEspecieDTO especie,
        UserDTOUsernameYId userDTO,
        int publicationCount,
        List<GetPublicacionDTOConLike> publicaciones
) {

    public static GetMascotaDTOConPublicaciones of(Mascota mascota, String url, Usuario usuarioActual) {
        List<GetPublicacionDTOConLike> publicaciones = mascota.getPublicacions() != null
                ? mascota.getPublicacions().stream()
                .map(publicacion -> {
                    boolean hasLiked = publicacion.getLikes().stream()
                            .anyMatch(like -> like.getUsuario().getId().equals(usuarioActual.getId()));
                    return GetPublicacionDTOConLike.of(publicacion, url, hasLiked);
                })
                .toList()
                : List.of();

        return new GetMascotaDTOConPublicaciones(
                mascota.getId(),
                mascota.getNombre(),
                mascota.getBiografia(),
                mascota.getFechaNacimiento(),
                url,
                GetRazaDTO.of(mascota.getRaza()),
                GetEspecieDTO.of(mascota.getEspecie()),
                UserDTOUsernameYId.of(mascota.getUsuario()),
                publicaciones.size(),
                publicaciones
        );
    }

}

