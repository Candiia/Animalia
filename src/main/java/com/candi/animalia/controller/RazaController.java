    package com.candi.animalia.controller;

    import com.candi.animalia.dto.especie.GetEspecieDTO;
    import com.candi.animalia.dto.paginacion.PaginacionDto;
    import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
    import com.candi.animalia.dto.raza.CreateRazaDTO;
    import com.candi.animalia.dto.raza.EditRazaDTO;
    import com.candi.animalia.dto.raza.GetRazaDTO;
    import com.candi.animalia.model.Raza;
    import com.candi.animalia.service.RazaService;
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
    @RequestMapping("/raza")
    @Tag(name = "Raza", description = "Controlador de raza, para realizar todas las operaciones de gestión")
    public class RazaController {

        private final RazaService razaService;

        @Operation(summary = "Obtiene todas las razas")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las razas",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetRazaDTO.class)),
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
                                                                                    "nombre": "Podenco"
                                                                                },
                                                                                {
                                                                                    "nombre": "Labrador Retriever"
                                                                                },
                                                                                {
                                                                                    "nombre": "SiamÃ©s"
                                                                                },
                                                                                {
                                                                                    "nombre": "Persa"
                                                                                },
                                                                                {
                                                                                    "nombre": "BengalÃ­"
                                                                                }
                                                                            ]
                                                                        }
                                            ]
                                        """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna razas",
                content = @Content),
        })
        @GetMapping("/")
        public PaginacionDto<GetRazaDTO> findAll(@PageableDefault(page=0, size=20) Pageable pageable){
            return PaginacionDto.of(razaService.findAll(pageable)
                    .map(GetRazaDTO::of));
        }

        @Operation(summary = "Obtiene una raza determinada")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido la raza",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = GetRazaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                        {
                                          "nombre": "Caniche"
                                        }
                                    """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "Raza no encontrada",
                content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content),
        })
        @GetMapping("/{id}")
        public GetRazaDTO findByid(@PathVariable UUID id){
            return GetRazaDTO.of(razaService.findById(id));
        }

        @Operation(summary = "Creación de una nueva raza")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado la raza",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = CreateRazaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                            {
                                                "nombre": "Bulldog francés"
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
        @PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<GetRazaDTO> createRaza(@RequestBody @Valid CreateRazaDTO razaDTO){
            return ResponseEntity.status(201)
                    .body(GetRazaDTO.of(razaService.save(razaDTO)));
        }

        @Operation(summary = "Editar una raza")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Raza editada correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = EditRazaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                            {
                                             "nombre":"Cocodrilo"
                                            }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "Raza no encontrada",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @PutMapping("/{id}")
        public GetRazaDTO edit(@RequestBody @Valid EditRazaDTO edit, @PathVariable UUID id) {
            return GetRazaDTO.of(razaService.edit(edit, id));
        }


        @Operation(summary = "Eliminar una raza")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "Raza eliminada correctamente",
                        content = @Content
                ),
                @ApiResponse(responseCode = "401",
                        description = "No estás autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteRaza(@PathVariable UUID id){
            razaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }


        @Operation(summary = "Obtiene todas las razas")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las razas",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetRazaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                            
                                                {
                                                                            "contenido": [
                                                                                {
                                                                                    "nombre": "Podenco"
                                                                                },
                                                                                {
                                                                                    "nombre": "Labrador Retriever"
                                                                                },
                                                                                {
                                                                                    "nombre": "SiamÃ©s"
                                                                                },
                                                                                {
                                                                                    "nombre": "Persa"
                                                                                },
                                                                                {
                                                                                    "nombre": "BengalÃ­"
                                                                                }
                                                                            ]
                                                                        }
                                        """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna razas",
                content = @Content),
        })
        @GetMapping("/todos")
        public List<GetRazaDTO> todos(){
            return razaService.todos();
        }
    }
