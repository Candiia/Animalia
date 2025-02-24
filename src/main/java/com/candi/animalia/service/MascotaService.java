package com.candi.animalia.service;

import com.candi.animalia.dto.mascota.CreateMascotaDTO;
import com.candi.animalia.dto.mascota.EditMascotaDTO;
import com.candi.animalia.dto.raza.EditRazaDTO;
import com.candi.animalia.files.model.FileMetadata;
import com.candi.animalia.files.service.StorageService;
import com.candi.animalia.model.*;
import com.candi.animalia.repository.EspecieRepository;
import com.candi.animalia.repository.MascotaRepository;
import com.candi.animalia.repository.RazaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final UsuarioRepository usuarioRepository;
    private final RazaRepository razaRepository;
    private final StorageService storageService;
    private final EspecieRepository especieRepository;

    public Page<Mascota> findAll(Pageable pageable) {
        Page<Mascota> result = mascotaRepository.findAllMascota(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay mascota con esos criterios de búsqueda");
        return result;
    }


    public Mascota findById(UUID id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay mascota con esa id " + id));

    }


    public Page<Mascota> findByUsuarioIdMascota(UUID usuarioId, Pageable pageable) {
        Page<Mascota> mascotas = mascotaRepository.findByUsuarioIdMascotas(usuarioId, pageable);
        if (mascotas.isEmpty()) {
            throw new EntityNotFoundException("No se encontraron mascotas para el usuario con ID: " + usuarioId);
        }
        return mascotas;
    }


    public Page<Mascota> findByUsuarioIdMascota(Usuario usuario, Pageable pageable) {
        Page<Mascota> mascotas = mascotaRepository.findByUsuarioIdMascotas(usuario.getId(), pageable);
        if (mascotas.isEmpty()) {
            throw new EntityNotFoundException("No hay mascotas");
        }
        return mascotas;
    }

    public Mascota save(CreateMascotaDTO createMascotaDTO,  MultipartFile file , Usuario usuario) {
        Usuario user = usuarioRepository.buscarConMascotas(usuario.getId());
        FileMetadata fileMetadata = storageService.store(file);
        Raza raza = razaRepository.findById(createMascotaDTO.razaId())
                .orElseThrow(() -> new EntityNotFoundException("Raza no encontrada"));

        Especie especie = especieRepository.findById(createMascotaDTO.especieId())
                .orElseThrow(() -> new EntityNotFoundException("Especie no encontrada"));

        Mascota mascota = mascotaRepository.save(
          Mascota.builder()
                  .nombre(createMascotaDTO.nombre())
                  .avatar(fileMetadata.getFilename())
                  .fechaNacimiento(createMascotaDTO.fechaNacimiento())
                  .biografia(createMascotaDTO.biografia())
                  .raza(raza)
                  .especie(especie)
                  .usuario(user)
                  .build()
        );


        user.addMascota(mascota);
        return mascotaRepository.save(mascota);
    }


    public Mascota edit(EditMascotaDTO editMascotaDTO, UUID id, MultipartFile file, Usuario usuario) {

            Mascota mascota = mascotaRepository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Mascota no encontrada"));


            mascota.setNombre(editMascotaDTO.nombre());
            mascota.setFechaNacimiento(editMascotaDTO.fechaNacimiento());
            mascota.setBiografia(editMascotaDTO.biografia());

            if (file != null && !file.isEmpty()) {
                FileMetadata fileMetadata = storageService.store(file);
                mascota.setAvatar(fileMetadata.getFilename());
            }
            Raza raza = razaRepository.findById(editMascotaDTO.razaId())
                    .orElseThrow(() -> new EntityNotFoundException("Raza no encontrada"));
            Especie especie = especieRepository.findById(editMascotaDTO.especieId())
                    .orElseThrow(() -> new EntityNotFoundException("Especie no encontrada"));

            mascota.setRaza(raza);
            mascota.setEspecie(especie);

        if (!mascota.getUsuario().getId().equals(usuario.getId())) {
            throw new EntityNotFoundException("No tienes permiso para editar esta mascota");
        }
            return mascotaRepository.save(mascota);
        }


    public void deleteById(UUID id){
        Mascota mascota = mascotaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay mascota con esa id " + id));
        Usuario usuario = mascota.getUsuario();

        if (usuario != null) {
            usuario.getMascotaList().remove(mascota);
        }
        mascotaRepository.deleteById(id);
    }

}
