package com.candi.animalia.service;

import com.candi.animalia.dto.especie.CreateEspecieDTO;
import com.candi.animalia.dto.especie.EditEspecieDTO;
import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Like;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.repository.EspecieRepository;
import com.candi.animalia.repository.LikeRepository;
import com.candi.animalia.repository.MascotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LikesService {

    private final LikeRepository likeRepository;

    public Page<Like> findAll(Pageable pageable, Usuario usuario) {

        Page<Like> result = likeRepository.findAllLikeByUser(usuario.getId(), pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No tienes dado ningún like");
        return result;
    }

}
