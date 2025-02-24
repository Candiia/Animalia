package com.candi.animalia.service;

import com.candi.animalia.dto.publicacion.CreatePublicacionDTO;
import com.candi.animalia.files.model.FileMetadata;
import com.candi.animalia.files.service.StorageService;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Publicacion;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.repository.MascotaRepository;
import com.candi.animalia.repository.PublicacionRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicacionService {

    private final PublicacionRepository publicacionRepository;
    private final StorageService storageService;
    private final MascotaRepository mascotaRepository;


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

    @Transactional
    public Publicacion save(CreatePublicacionDTO createPostDto, MultipartFile file, Usuario usuario, UUID mascotaId) {
        Mascota mascota = mascotaRepository.findById(mascotaId)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró la mascota con ID " + mascotaId));

        Usuario usuarioConPublicaciones = publicacionRepository.findByIdConPublicacions(usuario.getId())
                .orElseThrow((() -> new EntityNotFoundException("Usuario no encontrado")));

        if (!mascota.getUsuario().getId().equals(usuario.getId())) {
            throw new EntityNotFoundException("No tienes permiso para crear una publicación con esta mascota" + mascotaId);
        }

        FileMetadata fileMetadata = storageService.store(file);

        Publicacion publicacion = publicacionRepository.save(
                Publicacion.builder()
                        .descripcion(createPostDto.getDescripcion())
                        .fechaPublicacion(LocalDate.now())
                        .image(fileMetadata.getFilename())
                        .mascota(mascota)
                        .usuario(usuario)
                        .build()
        );
        mascota.addPublicacion(publicacion);
        usuarioConPublicaciones.addPublicacion(publicacion);
        return publicacion;
    }



    /*public Page<Publicacion> findByUsuarioIdPublicacion(Usuario usuario, Pageable pageable) {
        Page<Publicacion> publicacions = publicacionRepository.findAllPublicacionByMe(usuario.getId(), pageable);
        if (publicacions.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron publicaciones");
        }
        return publicacions;
    }*/





}
