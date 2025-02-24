package com.candi.animalia.service;

import com.candi.animalia.dto.mascota.EditMascotaDTO;
import com.candi.animalia.dto.publicacion.CreatePublicacionDTO;
import com.candi.animalia.dto.publicacion.EditPublicacionDTO;
import com.candi.animalia.files.model.FileMetadata;
import com.candi.animalia.files.service.StorageService;
import com.candi.animalia.model.*;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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


    @Transactional
    public void deleteById(UUID publicacionid, Usuario usuario) {

        Publicacion publicacionOpt = publicacionRepository.findById(publicacionid)
                .orElseThrow(() -> new EntityNotFoundException("Publicacion no encontrada"));

        if (publicacionOpt.getUsuario().getId().equals(usuario.getId())) {
            publicacionRepository.delete(publicacionOpt);
        }else{
            throw new EntityNotFoundException("No puedes eliminar una publicación que no es tuya");
        }
    }

    public Publicacion edit(EditPublicacionDTO editPublicacionDTO, UUID id, Usuario usuario) {

        Publicacion publicacion = publicacionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Publicación no encontrada"));

        if (!publicacion.getUsuario().getId().equals(usuario.getId())) {
            throw new EntityNotFoundException("No tienes permiso para editar esta publicación");
        }

        publicacion.setDescripcion(editPublicacionDTO.descripcion());

        return publicacionRepository.save(publicacion);
    }

     /*public Page<Publicacion> findByUsuarioIdPublicacion(Usuario usuario, Pageable pageable) {
        Page<Publicacion> publicacions = publicacionRepository.findAllPublicacionByMe(usuario.getId(), pageable);
        if (publicacions.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron publicaciones");
        }
        return publicacions;
    }*/

}









