package com.candi.animalia.service;

import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.model.UsuarioRepository;
import com.candi.animalia.repository.MascotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final UsuarioRepository usuarioRepository;

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


    public Mascota save(Mascota mascota, UUID usuarioId) {
        Usuario usuario = usuarioRepository.buscarConMascotas(usuarioId)
                .orElseThrow(() -> new EntityNotFoundException("Usuario con ID " + usuarioId + " no encontrado"));
        usuario.addMascota(mascota);

        return mascotaRepository.save(mascota);
    }

}
