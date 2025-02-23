package com.candi.animalia.service;

import com.candi.animalia.dto.especie.CreateEspecieDTO;
import com.candi.animalia.dto.especie.EditEspecieDTO;
import com.candi.animalia.model.Especie;
import com.candi.animalia.model.mascota.Mascota;
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

    public void deleteById(UUID id){
        Optional<Especie> especieOpt = especieRepository.findbyIdMascotas(id);
        Especie especie;
        List<Mascota> mascotas;

        if (especieOpt.isPresent()) {
            especie = especieOpt.get();

            mascotas = new ArrayList<>(especie.getMascotas());
            mascotas.forEach(especie::removeMascota);

            mascotaRepository.saveAll(mascotas);
            especieRepository.save(especie);

            especieRepository.deleteById(id);
        }
    }

}
