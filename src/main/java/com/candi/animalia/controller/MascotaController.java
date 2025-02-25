    package com.candi.animalia.controller;

    import com.candi.animalia.dto.mascota.CreateMascotaDTO;
    import com.candi.animalia.dto.mascota.EditMascotaDTO;
    import com.candi.animalia.dto.mascota.GetMascotaDTO;
    import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
    import com.candi.animalia.dto.raza.CreateRazaDTO;
    import com.candi.animalia.model.*;
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
    import org.springframework.data.domain.PageRequest;
    import org.springframework.data.domain.Pageable;
    import org.springframework.data.web.PageableDefault;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PostAuthorize;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/mascota")
    @Tag(name = "Mascotas", description = "Controlador de mascotas, para realizar todas las operaciones de gestión")
    public class MascotaController {

        private final MascotaService mascotaService;

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
            return mascotas.map(m -> GetMascotaDTO.of(m, getImageUrl(m.getAvatar())));
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
        @PostAuthorize("hasRole('ADMIN')")
        @GetMapping("/{id}")
        public GetMascotaDTO findByid(@PathVariable UUID id){
            Mascota mascota = mascotaService.findById(id);
            return GetMascotaDTO.of(mascota, getImageUrl(mascota.getAvatar()));
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
        @PostAuthorize("hasRole('ADMIN')")
        public Page<GetMascotaDTO> getMascotaByUsuario(@PathVariable UUID id, @PageableDefault(page=0, size=5) Pageable pageable) {
            Page<Mascota> mascotas = mascotaService.findByUsuarioIdMascota(id,pageable);
            return mascotas.map(m -> GetMascotaDTO.of(m, getImageUrl(m.getAvatar())));
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
        @GetMapping("/me")
        @PostAuthorize("hasAnyRole('USER', 'ADMIN')")
        public Page<GetMascotaDTO> getMascotaByMe(@AuthenticationPrincipal Usuario usuario, @PageableDefault(page=0, size=5) Pageable pageable) {
            Page<Mascota> mascotas = mascotaService.findByUsuarioIdMascota(usuario,pageable);
            return mascotas.map(m -> GetMascotaDTO.of(m, getImageUrl(m.getAvatar())));
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
        @PostMapping("/usuario")
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public ResponseEntity<GetMascotaDTO> createMascota(@Valid @RequestPart("post")CreateMascotaDTO mascotaDto, @RequestPart("file")MultipartFile file,
                                                           @AuthenticationPrincipal Usuario usuario) {

            Mascota mascota = mascotaService.save(mascotaDto, file, usuario);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(GetMascotaDTO.of(mascota, getImageUrl(mascota.getAvatar())));
        }


        @Operation(summary = "Editar datos de una mascota")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Mascota editada correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = EditMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                             {
                                              "titulo":"Nuevo Título",
                                              "descripcion":"Nueva Descripción",
                                              "categoria": {"id": 1}
                                             }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "No tienes permiso para editar esta mascota",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No estas autorizado",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content)
        })
        @PutMapping("/{id}")
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public GetMascotaDTO edit(@RequestPart("post") @Valid EditMascotaDTO edit, @PathVariable UUID id, @RequestPart("file")MultipartFile file, @AuthenticationPrincipal Usuario usuari) {
            Mascota updatedMascota = mascotaService.edit(edit, id, file, usuari);
            return GetMascotaDTO.of(updatedMascota, getImageUrl(updatedMascota.getAvatar()));

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
        @DeleteMapping("/{id}")
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public ResponseEntity<?> deleteMascota(@PathVariable UUID id){
            mascotaService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        public String getImageUrl(String filename) {
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(filename)
                    .toUriString();
        }

        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        @GetMapping("/buscar")
        public Page<Mascota> buscarPorEspecieYRaza(@RequestParam("especie") String nombreEspecie, @RequestParam("raza") String nombreRaza,
                                                   @PageableDefault(page=0, size=5) Pageable pageable) {
            return mascotaService.buscarEspecieYRaza(nombreRaza, nombreEspecie, pageable);
        }

    }
