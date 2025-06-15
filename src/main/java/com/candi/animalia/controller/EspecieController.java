    package com.candi.animalia.controller;

    import com.candi.animalia.dto.comentario.GetComentarioDTO;
    import com.candi.animalia.dto.especie.CreateEspecieDTO;
    import com.candi.animalia.dto.especie.EditEspecieDTO;
    import com.candi.animalia.dto.especie.GetEspecieDTO;
    import com.candi.animalia.dto.paginacion.PaginacionDto;
    import com.candi.animalia.dto.raza.EditRazaDTO;
    import com.candi.animalia.dto.raza.GetRazaDTO;
    import com.candi.animalia.model.Especie;
    import com.candi.animalia.service.EspecieService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.media.ArraySchema;
    import io.swagger.v3.oas.annotations.media.Content;
    import io.swagger.v3.oas.annotations.media.ExampleObject;
    import io.swagger.v3.oas.annotations.media.Schema;
    import io.swagger.v3.oas.annotations.responses.ApiResponse;
    import io.swagger.v3.oas.annotations.responses.ApiResponses;
    import io.swagger.v3.oas.annotations.tags.Tag;
    import jakarta.validation.Valid;
    import lombok.RequiredArgsConstructor;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PostAuthorize;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/especie")
    @Tag(name = "Especie", description = "Controlador de especies, para realizar todas las operaciones de gestión")
    public class EspecieController {

        private final EspecieService especieService;

        @Operation(summary = "Obtiene todas las especies")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las especies",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetEspecieDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                    [
                                                                        {
                                                                            "numPagina": 0,
                                                                            "tamanioPagina": 5,
                                                                            "elementosEncontrados": 11,
                                                                            "paginasTotales": 3,
                                                                            "contenido": [
                                                                                {
                                                                                    "nombre": "Canino",
                                                                                    "localDate": "2025-01-01"
                                                                                },
                                                                                {
                                                                                    "nombre": "Felino",
                                                                                    "localDate": "2025-01-01"
                                                                                },
                                                                                {
                                                                                    "nombre": "Aves",
                                                                                    "localDate": "2022-07-22"
                                                                                },
                                                                                {
                                                                                    "nombre": "Reptiles",
                                                                                    "localDate": "2025-01-11"
                                                                                },
                                                                                {
                                                                                    "nombre": "Anfibios",
                                                                                    "localDate": "2022-01-01"
                                                                                }
                                                                            ]
                                                                        }
                                                                    ]
                                                                """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna especie",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PostAuthorize("hasAnyRole('USER', 'ADMIN')")
        @GetMapping("/")
        public PaginacionDto<GetEspecieDTO> findAll(@PageableDefault(page=0, size=20) Pageable pageable){
            return PaginacionDto.of(especieService.findAll(pageable)
                    .map(GetEspecieDTO::of));
        }

        @Operation(summary = "Obtiene una especie determinada")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido la especie",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = GetEspecieDTO.class)),
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
                description = "Espcie no encontrada",
                content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content),
        })
        @GetMapping("/{id}")
        @PostAuthorize("hasRole('ADMIN')")
        public GetEspecieDTO findByid(@PathVariable UUID id){
            return GetEspecieDTO.of(especieService.findById(id));
        }

        @Operation(summary = "Creación de una nueva especie")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado la espcie",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = CreateEspecieDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                {
                                                                    "nombre": "León",
                                                                    "localDate": "2025-02-23"
                                                                }
                                                            """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "400",
                        description = "¡Error!, Datos incorrectos ",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No estas autorizado",
                        content = @Content)
        })
        @PostMapping()
        @PostAuthorize("hasRole('ADMIN')")
        public ResponseEntity<GetEspecieDTO> createEspecie(@RequestBody @Valid CreateEspecieDTO especieDTO){
            return ResponseEntity.status(201)
                    .body(GetEspecieDTO.of(especieService.save(especieDTO)));
        }

        @Operation(summary = "Editar una Especie")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Especie editada correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = EditEspecieDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                            {
                                                              "nombre": "Caracol",
                                                              "localDate": "2025-01-01"
                                                            }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "Especie no encontrada",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/{id}")
        public GetEspecieDTO edit(@RequestBody @Valid EditEspecieDTO edit, @PathVariable UUID id) {
            return GetEspecieDTO.of(especieService.edit(edit, id));
        }

        @Operation(summary = "Eliminar una especie")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "Especie eliminada correctamente",
                        content = @Content
                ),
                @ApiResponse(responseCode = "401",
                        description = "No estás autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteEspecie(@PathVariable UUID id){
            especieService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        @Operation(summary = "Obtiene todas las especies")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las especies",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetEspecieDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                    
                                                                        {
                                                                            "contenido": [
                                                                                {
                                                                                    "nombre": "Canino",
                                                                                    "localDate": "2025-01-01"
                                                                                },
                                                                                {
                                                                                    "nombre": "Felino",
                                                                                    "localDate": "2025-01-01"
                                                                                },
                                                                                {
                                                                                    "nombre": "Aves",
                                                                                    "localDate": "2022-07-22"
                                                                                },
                                                                                {
                                                                                    "nombre": "Reptiles",
                                                                                    "localDate": "2025-01-11"
                                                                                },
                                                                                {
                                                                                    "nombre": "Anfibios",
                                                                                    "localDate": "2022-01-01"
                                                                                }
                                                                            ]
                                                                        }
                                                               
                                                                """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna especie",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PostAuthorize("hasAnyRole('USER', 'ADMIN')")
        @GetMapping("/todos")
        public List<GetEspecieDTO> todos(){
            return   especieService.todos();
        }

    }
