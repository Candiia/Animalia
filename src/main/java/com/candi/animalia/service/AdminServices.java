package com.candi.animalia.service;


import com.candi.animalia.dto.admin.EstadisticasDTO;
import com.candi.animalia.dto.admin.PublicacionesPorMesDTO;
import com.candi.animalia.model.Like;
import com.candi.animalia.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class AdminServices {

    private final UsuarioRepository usuarioRepository;
    private final ComentarioRepository comentarioRepository;
    private final MascotaRepository mascotaRepository;
    private final LikeRepository likeRepository;
    private final EspecieRepository especieRepository;
    private final RazaRepository razaRepository;
    private final PublicacionRepository publicacionRepository;




    public EstadisticasDTO contarListas(){
        return new EstadisticasDTO(
                usuarioRepository.contarUsuariosActivos(),
                mascotaRepository.contarMascotas(),
                especieRepository.contarEspecies(),
                razaRepository.contarRazas(),
                likeRepository.contarLikes(),
                comentarioRepository.contarComentarios()
                );
    }

    public List<PublicacionesPorMesDTO> obtenerEstadisticasPublicacionesPorMes() {
        List<LocalDate> fechas = publicacionRepository.obtenerFechasDePublicaciones();

        Map<YearMonth, Long> publicacionesPorMes = fechas.stream()
                .collect(Collectors.groupingBy(
                        YearMonth::from,
                        Collectors.counting()
                ));

        List<PublicacionesPorMesDTO> result = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            YearMonth yearMonth = YearMonth.of(LocalDate.now().getYear(), month);
            Long cantidad = publicacionesPorMes.getOrDefault(yearMonth, 0L);
            result.add(new PublicacionesPorMesDTO(yearMonth, cantidad));
        }

        return result;
    }

}
