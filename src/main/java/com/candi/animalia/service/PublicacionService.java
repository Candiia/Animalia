package com.candi.animalia.service;

import com.candi.animalia.dto.mascota.EditMascotaDTO;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.model.UsuarioRepository;
import com.candi.animalia.repository.EspecieRepository;
import com.candi.animalia.repository.MascotaRepository;
import com.candi.animalia.repository.PublicacionRepository;
import com.candi.animalia.repository.RazaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;


    public Page<Publicacion> findAll(Pageable pageable) {
        Page<Publicacion> result = publicacionRepository.findAllPublicacion(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay publicaciones con esos criterios de búsqueda");
        return result;
    }

    public Publicacion findById(UUID id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay publicación con esa id " + id));

    }


    /*public Page<Publicacion> findByUsuarioIdPublicacion(Usuario usuario, Pageable pageable) {
        Page<Publicacion> publicacions = publicacionRepository.findAllPublicacionByMe(usuario.getId(), pageable);
        if (publicacions.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron publicaciones");
        }
        return publicacions;
    }*/





}
