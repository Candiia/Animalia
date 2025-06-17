package com.candi.animalia.service;

import com.candi.animalia.dto.raza.CreateRazaDTO;
import com.candi.animalia.dto.raza.EditRazaDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.error.RazaConMascotaException;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.MascotaRepository;
import com.candi.animalia.repository.RazaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RazaService {

    private final RazaRepository razaRepository;
    private final MascotaRepository mascotaRepository;

    public Page<Raza> findAll(Pageable pageable) {
        Page<Raza> result = razaRepository.findAllRaza(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay raza con esos criterios de búsqueda");
        return result;
    }

    public List<GetRazaDTO> todos() {
        List<Raza> razas = razaRepository.findAll();
        return razas.stream()
                .map(GetRazaDTO::of)
                .collect(Collectors.toList());
    }

    public Raza findById(UUID id) {
        return razaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay raza con esa id " + id));

    }

    public Raza save(CreateRazaDTO raza) {
        return razaRepository.save(Raza.builder()
                .nombre(raza.nombre())
                .build());
    }

    public Raza edit(EditRazaDTO editRazaDTO, UUID id) {
        return razaRepository.findById(id)
                .map(old -> {
                    old.setNombre(editRazaDTO.nombre());
                    return razaRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay raza con esa id " + id));
    }


    public void deleteById(UUID id) {
        Optional<Raza> razaOpt = razaRepository.findbyIdMascotas(id);
        if (razaOpt.isPresent()) {
            Raza raza = razaOpt.get();

            if (!raza.getMascotas().isEmpty()) {
                throw new RazaConMascotaException("No se puede eliminar la raza porque tiene mascotas asociadas.");
            }
            razaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No hay raza con esa id " + id);
        }
    }

}
