package com.candi.animalia.service;

import com.candi.animalia.dto.especie.CreateEspecieDTO;
import com.candi.animalia.dto.especie.EditEspecieDTO;
import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.error.EspecieConMascotasException;
import com.candi.animalia.model.Especie;
import com.candi.animalia.model.Mascota;
import com.candi.animalia.model.Raza;
import com.candi.animalia.repository.EspecieRepository;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EspecieService {

    private final EspecieRepository especieRepository;
    private final MascotaRepository mascotaRepository;

    public Page<Especie> findAll(Pageable pageable) {
        Page<Especie> result = especieRepository.findAllEspecie(pageable);
        if (result.isEmpty())
            throw new EntityNotFoundException("No hay especie con esos criterios de búsqueda");
        return result;
    }

    public List<GetEspecieDTO> todos() {
        List<Especie> especies = especieRepository.findAll();
        return especies.stream()
                .map(GetEspecieDTO::of)
                .collect(Collectors.toList());
    }

    public Especie findById(UUID id) {
        return especieRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No hay especie con esa id " + id));

    }

    public Especie save(CreateEspecieDTO especieDTO) {
        return especieRepository
                .save(Especie.builder()
                        .fechaRegistro(LocalDate.now())
                        .nombre(especieDTO.nombre())
                        .build());
    }


    public Especie edit(EditEspecieDTO especieDTO, UUID id) {
        return especieRepository.findById(id)
                .map(old -> {
                    old.setNombre(especieDTO.nombre());
                    return especieRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No hay especie con esa id " + id));
    }

    public void deleteById(UUID id) {
        Optional<Especie> especieOpt = especieRepository.findbyIdMascotas(id);
        if (especieOpt.isPresent()) {
            Especie especie = especieOpt.get();

            if (!especie.getMascotas().isEmpty()) {
                throw new EspecieConMascotasException("No se puede eliminar la especie porque tiene mascotas asociadas.");
            }
            especieRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("No hay especie con esa id " + id);
        }
    }
}
