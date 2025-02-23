    package com.candi.animalia.controller;

    import com.candi.animalia.dto.mascota.CreateMascotaDTO;
    import com.candi.animalia.dto.mascota.GetMascotaDTO;
    import com.candi.animalia.dto.raza.CreateRazaDTO;
    import com.candi.animalia.model.Especie;
    import com.candi.animalia.model.Mascota;
    import com.candi.animalia.model.Raza;
    import com.candi.animalia.service.EspecieService;
    import com.candi.animalia.service.MascotaService;
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

    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/mascota")
    @Tag(name = "Mascotas", description = "Controlador de mascotas, para realizar todas las operaciones de gestión")
    public class MascotaController {

        private final MascotaService mascotaService;
        private final RazaService razaService;
        private final EspecieService especieService;

        @Operation(summary = "Obtiene todas las mascotas")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las especies",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                    [
                                                                      {
                                                                          "content": [
                                                                              {
                                                                                  "nombre": "Max",
                                                                                  "biografia": "Un perro muy juguetÃ³n y amigable.",
                                                                                  "fechaNacimiento": "2020-05-15",
                                                                                  "avatar": "https://example.com/avatars/max.jpg",
                                                                                  "raza": {
                                                                                      "nombre": "Labrador Retriever"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Canino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user1",
                                                                                      "email": "user1@example.com",
                                                                                      "fechaRegistro": "2025-02-01"
                                                                                  }
                                                                              },
                                                                              {
                                                                                  "nombre": "Luna",
                                                                                  "biografia": "Gata persa tranquila y cariÃ±osa.",
                                                                                  "fechaNacimiento": "2019-08-20",
                                                                                  "avatar": "https://example.com/avatars/luna.jpg",
                                                                                  "raza": {
                                                                                      "nombre": "Persa"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Felino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user2",
                                                                                      "email": "user2@example.com",
                                                                                      "fechaRegistro": "2025-02-02"
                                                                                  }
                                                                              },
                                                                              {
                                                                                  "nombre": "Rocky",
                                                                                  "biografia": "Beagle aventurero y curioso.",
                                                                                  "fechaNacimiento": "2021-01-10",
                                                                                  "avatar": "https://example.com/avatars/rocky.jpg",
                                                                                  "raza": {
                                                                                      "nombre": "Beagle"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Canino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user3",
                                                                                      "email": "user3@example.com",
                                                                                      "fechaRegistro": "2025-02-03"
                                                                                  }
                                                                              },
                                                                              {
                                                                                  "nombre": "Nala",
                                                                                  "biografia": "BengalÃ­ activa y juguetona.",
                                                                                  "fechaNacimiento": "2022-03-05",
                                                                                  "avatar": "https://example.com/avatars/nala.jpg",
                                                                                  "raza": {
                                                                                      "nombre": "BengalÃ­"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Felino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user4",
                                                                                      "email": "user4@example.com",
                                                                                      "fechaRegistro": "2025-02-04"
                                                                                  }
                                                                              },
                                                                              {
                                                                                  "nombre": "Thor",
                                                                                  "biografia": "Husky siberiano con mucha energÃ­a.",
                                                                                  "fechaNacimiento": "2018-07-21",
                                                                                  "avatar": "https://example.com/avatars/thor.jpg",
                                                                                  "raza": {
                                                                                      "nombre": "Husky Siberiano"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Canino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user2",
                                                                                      "email": "user2@example.com",
                                                                                      "fechaRegistro": "2025-02-02"
                                                                                  }
                                                                              }
                                                                          ],
                                                                          "pageable": {
                                                                              "pageNumber": 0,
                                                                              "pageSize": 5,
                                                                              "sort": {
                                                                                  "empty": true,
                                                                                  "sorted": false,
                                                                                  "unsorted": true
                                                                              },
                                                                              "offset": 0,
                                                                              "paged": true,
                                                                              "unpaged": false
                                                                          },
                                                                          "last": false,
                                                                          "totalPages": 2,
                                                                          "totalElements": 6,
                                                                          "size": 5,
                                                                          "number": 0,
                                                                          "sort": {
                                                                              "empty": true,
                                                                              "sorted": false,
                                                                              "unsorted": true
                                                                          },
                                                                          "first": true,
                                                                          "numberOfElements": 5,
                                                                          "empty": false
                                                                      }
                                                                    ]
                                                                """
                                                )
                                        })
                        }), @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna mascota",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content),
                @ApiResponse(responseCode = "403",
                description = "Acceso denegado",
                content = @Content)
        })
        @PostAuthorize("hasRole('ADMIN')")
        @GetMapping("/admin")
        public Page<GetMascotaDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable){
            Page<Mascota> mascotas = mascotaService.findAll(pageable);
            return mascotas.map(GetMascotaDTO::of);
        }

        @Operation(summary = "Obtiene una mascota determinada")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido la mascota",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = GetMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                       {
                                                                       "nombre": "Max",
                                                                       "biografia": "Un perro muy juguetÃ³n y amigable.",
                                                                       "fechaNacimiento": "2020-05-15",
                                                                       "avatar": "https://example.com/avatars/max.jpg",
                                                                       "raza": {
                                                                           "nombre": "Labrador Retriever"
                                                                       },
                                                                       "especie": {
                                                                           "nombre": "Canino",
                                                                           "localDate": "2025-01-01"
                                                                       },
                                                                       "userDTO": {
                                                                           "username": "user1",
                                                                           "email": "user1@example.com",
                                                                           "fechaRegistro": "2025-02-01"
                                                                       }
                                                                   }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                description = "Mascota no encontrada",
                content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content),
        })
        @GetMapping("/{id}")
        public GetMascotaDTO findByid(@PathVariable UUID id){
            return GetMascotaDTO.of(mascotaService.findById(id));
        }


        @Operation(summary = "Obtiene todos las mascotas del usuario")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las mascotas del usuario",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                        [{
                                                                              "content": [
                                                                                  {
                                                                                      "nombre": "Rocky",
                                                                                      "biografia": "Beagle aventurero y curioso.",
                                                                                      "fechaNacimiento": "2021-01-10",
                                                                                      "avatar": "https://example.com/avatars/rocky.jpg",
                                                                                      "raza": {
                                                                                          "nombre": "Beagle"
                                                                                      },
                                                                                      "especie": {
                                                                                          "nombre": "Canino",
                                                                                          "localDate": "2025-01-01"
                                                                                      },
                                                                                      "userDTO": {
                                                                                          "username": "user3",
                                                                                          "email": "user3@example.com",
                                                                                          "fechaRegistro": "2025-02-03"
                                                                                      }
                                                                                  },
                                                                                  {
                                                                                      "nombre": "Milo",
                                                                                      "biografia": "Un pez dorado que adora nadar.",
                                                                                      "fechaNacimiento": "2023-01-15",
                                                                                      "avatar": "https://example.com/avatars/milo.jpg",
                                                                                      "raza": null,
                                                                                      "especie": {
                                                                                          "nombre": "Peces",
                                                                                          "localDate": "2023-01-01"
                                                                                      },
                                                                                      "userDTO": {
                                                                                          "username": "user3",
                                                                                          "email": "user3@example.com",
                                                                                          "fechaRegistro": "2025-02-03"
                                                                                      }
                                                                                  }
                                                                              ],
                                                                              "pageable": {
                                                                                  "pageNumber": 0,
                                                                                  "pageSize": 5,
                                                                                  "sort": {
                                                                                      "empty": true,
                                                                                      "sorted": false,
                                                                                      "unsorted": true
                                                                                  },
                                                                                  "offset": 0,
                                                                                  "paged": true,
                                                                                  "unpaged": false
                                                                              },
                                                                              "last": true,
                                                                              "totalElements": 2,
                                                                              "totalPages": 1,
                                                                              "size": 5,
                                                                              "number": 0,
                                                                              "sort": {
                                                                                  "empty": true,
                                                                                  "sorted": false,
                                                                                  "unsorted": true
                                                                              },
                                                                              "first": true,
                                                                              "numberOfElements": 2,
                                                                              "empty": false
                                                                          }
                                        ]
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ninguna mascota para el usuario",
                content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content),
        })
        @GetMapping("/usuario/{id}")
        @PostAuthorize("hasRole('USER')")
        public Page<GetMascotaDTO> getIncidenciasByUsuario(@PathVariable UUID id, @PageableDefault(page=0, size=5) Pageable pageable) {
            Page<Mascota> mascotas = mascotaService.findByUsuarioIdMascota(id,pageable);
            return mascotas.map(GetMascotaDTO::of);
        }



        @Operation(summary = "Creación de una nueva mascota")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado la mascota",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = CreateMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                            {
                                                                             "nombre": "Koby",
                                                                             "biografia": "Soy perrete muy amigable",
                                                                             "fechaNacimiento": "2002-02-11",
                                                                             "avatar": "dksadkjsahkjdhsakjhdksaj.png",
                                                                             "raza": {
                                                                                 "nombre": "Golden Retriever"
                                                                             },
                                                                             "especie": {
                                                                                 "nombre": "Canino",
                                                                                 "localDate": "2025-01-01"
                                                                             },
                                                                             "userDTO": {
                                                                                 "username": "user2",
                                                                                 "email": "user2@example.com",
                                                                                 "fechaRegistro": "2025-02-02"
                                                                             }
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
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content)
        })
        @PostMapping("/usuario/{usuarioId}")
        @PostAuthorize("hasRole('USER')")
        public ResponseEntity<GetMascotaDTO> createMascota(@RequestBody @Valid CreateMascotaDTO mascota, @PathVariable UUID usuarioId) {
            Raza raza = razaService.findById(mascota.razaId());
            Especie especie = especieService.findById(mascota.especieId());

            return ResponseEntity.status(201)
                    .body(GetMascotaDTO.of(
                            mascotaService.save(
                                    mascota.toMascota(raza, especie), usuarioId)
                    ));
        }


        @Operation(summary = "Eliminar una mascota")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "Mascota eliminada correctamente",
                        content = @Content
                ),
                @ApiResponse(responseCode = "401",
                        description = "No estás autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('USER')")
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteRaza(@PathVariable UUID id){
            mascotaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }
