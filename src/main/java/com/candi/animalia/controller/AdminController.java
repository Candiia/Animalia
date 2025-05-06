package com.candi.animalia.controller;

import com.candi.animalia.dto.admin.EstadisticasDTO;
import com.candi.animalia.dto.admin.PublicacionesPorMesDTO;
import com.candi.animalia.dto.especie.GetEspecieDTO;
import com.candi.animalia.service.AdminServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@Tag(name = "Admin", description = "Controlador de admin, para realizar todas las operaciones de gestión")
public class AdminController {

    private final AdminServices adminServices;

    @Operation(summary = "Obtener el número total de cada lista")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha obtenido el total de números",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EstadisticasDTO.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                                {
                                                                   "nombre": "Felino",
                                                                   "localDate": "2025-01-01"
                                                                }
                                                              """
                                            )
                                    })
                    }), @ApiResponse(responseCode = "404",
            description = "Estadísitcas no encontrada",
            content = @Content),
            @ApiResponse(responseCode = "401",
                    description = "No autorizado",
                    content = @Content),
    })
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/estadisticas")
    public EstadisticasDTO contarListas(){
        return adminServices.contarListas();
    }


    @Operation(summary = "Obtener número de publicaciones por mes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Conteo de publicaciones por mes",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = PublicacionesPorMesDTO.class)))),
            @ApiResponse(responseCode = "401", description = "No autorizado", content = @Content)
    })
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/estadisticas/publicaciones/por/mes")
    public List<PublicacionesPorMesDTO> publicacionesPorMes() {
        return adminServices.obtenerEstadisticasPublicacionesPorMes();
    }

}
