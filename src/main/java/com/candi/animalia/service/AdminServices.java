package com.candi.animalia.service;


import com.candi.animalia.dto.admin.EstadisticasDTO;
import com.candi.animalia.model.Like;
import com.candi.animalia.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServices {

    private final UsuarioRepository usuarioRepository;
    private final ComentarioRepository comentarioRepository;
    private final MascotaRepository mascotaRepository;
    private final LikeRepository likeRepository;
    private final EspecieRepository especieRepository;
    private final RazaRepository razaRepository;


    public EstadisticasDTO contarListas(){
        return new EstadisticasDTO(
                usuarioRepository.contarUsuariosActivos(),
                mascotaRepository.contarMascotas(),
                especieRepository.contarEspecies(),
                razaRepository.contarRazas(),
                likeRepository.contarLikes(),
                comentarioRepository.contarComentarios()
                );
    }
}
