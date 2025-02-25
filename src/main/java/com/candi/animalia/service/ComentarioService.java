package com.candi.animalia.service;


import com.candi.animalia.dto.comentario.CreateComentarioDTO;
import com.candi.animalia.dto.like.CreateLikeDTO;
import com.candi.animalia.model.*;
import com.candi.animalia.repository.ComentarioRepository;
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
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PublicacionRepository publicacionRepository;


    public Page<Comentario> findAllComentByPublication(Pageable pageable,UUID idPublicacion) {
        Page<Comentario> result = comentarioRepository.findAllByPublicacionId(pageable, idPublicacion);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay ningún comentario");
        return result;
    }


    public Comentario save(CreateComentarioDTO comentario, Usuario usuario, UUID publicacionId) {

        Publicacion publicacion = publicacionRepository.findById(publicacionId)
                .orElseThrow(() -> new EntityNotFoundException("No se ha encontrado la publicación con ID: " + publicacionId));

        Comentario nuevoComentario = Comentario.builder()
                .publicacion(publicacion)
                .usuario(usuario)
                .texto(comentario.texto())
                .fechaRealizada(LocalDate.now())
                .build();

        return comentarioRepository.save(nuevoComentario);
    }


}
