package com.candi.animalia.service;


import com.candi.animalia.dto.like.CreateLikeDTO;
import com.candi.animalia.model.*;

import com.candi.animalia.repository.LikeRepository;

import com.candi.animalia.repository.PublicacionRepository;
import com.candi.animalia.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikeRepository likeRepository;
    private final UsuarioRepository usuarioRepository;
    private final PublicacionRepository publicacionRepository;

    public Page<Like> findAll(Pageable pageable, Usuario usuario) {

        Page<Like> result = likeRepository.findAllLikeByUser(usuario.getId(), pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No tienes dado ningún like");
        return result;
    }


    public Like save(CreateLikeDTO like, Usuario usuario) {
        Publicacion publicacion = publicacionRepository.findById(like.publicacionId())
                .orElseThrow(() -> new EntityNotFoundException("No se ha enocntrado la publicación"));
        LikePK likePK = new LikePK();

        if (likeRepository.existsByPublicacionAndUsuario(publicacion, usuario)) {
            throw new EntityNotFoundException("El usuario ya dio like a esta publicación");
        }

        likePK.setPublicacionId(publicacion.getId());
        likePK.setUsuarioId(usuario.getId());

        return likeRepository.save(Like.builder()
                .publicacion(publicacion)
                .likePK(likePK)
                .usuario(usuario)
                .fechaRealizada(LocalDate.now())
                .build());


    }


    public void deleteLike(UUID publicacionId, Usuario usuario) {
        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la publicación"));

        Like like = likeRepository.findByPublicacionAndUsuario(publicacion, usuario)
                .orElseThrow(() -> new EntityNotFoundException("No has dado like a esta publicación"));

        likeRepository.delete(like);
    }
}
