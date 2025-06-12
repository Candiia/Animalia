    package com.candi.animalia.controller;

    import com.candi.animalia.dto.comentario.GetComentarioDTO;
    import com.candi.animalia.dto.mascota.CreateMascotaDTO;
    import com.candi.animalia.dto.mascota.EditMascotaDTO;
    import com.candi.animalia.dto.mascota.GetMascotaDTO;
    import com.candi.animalia.dto.paginacion.PaginacionDto;
    import com.candi.animalia.dto.publicacion.*;
    import com.candi.animalia.model.*;
    import com.candi.animalia.service.EspecieService;
    import com.candi.animalia.service.MascotaService;
    import com.candi.animalia.service.PublicacionService;
    import com.candi.animalia.service.RazaService;
    import io.swagger.v3.oas.annotations.Operation;
    import io.swagger.v3.oas.annotations.Parameter;
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
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PostAuthorize;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.core.context.SecurityContextHolder;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.multipart.MultipartFile;
    import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

    import java.util.List;
    import java.util.Map;
    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/publicacion")
    @Tag(name = "Publicación", description = "Controlador de publicaciones, para realizar todas las operaciones de gestión")
    public class PublicacionController {

        private final PublicacionService publicacionService;


        @Operation(summary = "Obtiene todas las publicaciones")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas las publicaciones",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetPublicacionDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                        [
                                        {
                                                                        "numPagina": 0,
                                                                        "tamanioPagina": 5,
                                                                        "elementosEncontrados": 8,
                                                                        "paginasTotales": 2,
                                                                        "contenido": [
                                                                            {
                                                                                "imageURL": "http://localhost:8080/download/Image",
                                                                                "descripcion": "Max disfrutando del parque en un dÃ­a soleado.",
                                                                                "fechaRegistro": "2025-02-20",
                                                                                "usuario": {
                                                                                    "username": "user1",
                                                                                    "email": "user1@example.com",
                                                                                    "fechaRegistro": "2025-02-01"
                                                                                },
                                                                                "mascotaDTO": {
                                                                                    "nombre": "Max",
                                                                                    "biografia": "Un perro muy juguetÃ³n y amigable.",
                                                                                    "fechaNacimiento": "2020-05-15",
                                                                                    "avatar": "Image",
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
                                                                            },
                                                                            {
                                                                                "imageURL": "http://localhost:8080/download/Image",
                                                                                "descripcion": "Luna se escondiÃ³ en una caja hoy, Â¡es tan adorable!",
                                                                                "fechaRegistro": "2025-02-21",
                                                                                "usuario": {
                                                                                    "username": "user2",
                                                                                    "email": "user2@example.com",
                                                                                    "fechaRegistro": "2025-02-02"
                                                                                },
                                                                                "mascotaDTO": {
                                                                                    "nombre": "Luna",
                                                                                    "biografia": "Gata persa tranquila y cariÃ±osa.",
                                                                                    "fechaNacimiento": "2019-08-20",
                                                                                    "avatar": "Image",
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
                                                                                }
                                                                            },
                                                                            {
                                                                                "imageURL": "http://localhost:8080/download/Image",
                                                                                "descripcion": "Rocky participarÃ¡ en una carrera de perros este fin de semana.",
                                                                                "fechaRegistro": "2025-02-22",
                                                                                "usuario": {
                                                                                    "username": "user3",
                                                                                    "email": "user3@example.com",
                                                                                    "fechaRegistro": "2025-02-03"
                                                                                },
                                                                                "mascotaDTO": {
                                                                                    "nombre": "Rocky",
                                                                                    "biografia": "Beagle aventurero y curioso.",
                                                                                    "fechaNacimiento": "2021-01-10",
                                                                                    "avatar": "Image",
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
                                                                                }
                                                                            },
                                                                            {
                                                                                "imageURL": "http://localhost:8080/download/Image",
                                                                                "descripcion": "Nala cazando una pelota en el jardÃ­n.",
                                                                                "fechaRegistro": "2025-02-23",
                                                                                "usuario": {
                                                                                    "username": "user4",
                                                                                    "email": "user4@example.com",
                                                                                    "fechaRegistro": "2025-02-04"
                                                                                },
                                                                                "mascotaDTO": {
                                                                                    "nombre": "Nala",
                                                                                    "biografia": "BengalÃ­ activa y juguetona.",
                                                                                    "fechaNacimiento": "2022-03-05",
                                                                                    "avatar": "Image",
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
                                                                                }
                                                                            },
                                                                            {
                                                                                "imageURL": "http://localhost:8080/download/Image",
                                                                                "descripcion": "Thor ladrando a la nieve como si fuera la primera vez.",
                                                                                "fechaRegistro": "2025-02-24",
                                                                                "usuario": {
                                                                                    "username": "user2",
                                                                                    "email": "user2@example.com",
                                                                                    "fechaRegistro": "2025-02-02"
                                                                                },
                                                                                "mascotaDTO": {
                                                                                    "nombre": "Thor",
                                                                                    "biografia": "Husky siberiano con mucha energÃ­a.",
                                                                                    "fechaNacimiento": "2018-07-21",
                                                                                    "avatar": "Image",
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
                                                                            }
                                                                        ]
                                                                    }
                                        ]
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "No se ha encontrado ninguna publicación",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content),
        })
        @GetMapping()
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public PaginacionDto<GetPublicacionDTOConLike> getAll(@PageableDefault(page = 0, size = 20) Pageable pageable) {
            String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
            return PaginacionDto.of(
                    publicacionService.findAll(pageable)
                            .map(m -> {
                                boolean hasLike = m.getLikes().stream()
                                        .anyMatch(like -> like.getUsuario().getUsername().equals(currentUsername));

                                return GetPublicacionDTOConLike.of(m, getImageUrl(m.getImage()), hasLike);
                            })
            );
        }




        @Operation(summary = "Obtiene una publicación determinada")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido la publicación correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = GetPublicacionDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                       {
                                                                       "tipo": "Image",
                                                                       "descripcion": "Max disfrutando del parque en un día soleado.",
                                                                       "fechaRegistro": "2025-02-20",
                                                                       "like":"3",
                                                                       "comentario":"3"
                                                                   }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "Publicación no encontrada",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content),
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @GetMapping("/{id}")
        public GetPublicacionDTOConLike findByid(@PathVariable UUID id, @AuthenticationPrincipal Usuario usuario) {
            return publicacionService.findByIdConLike(id, usuario);
        }


        @Operation(summary = "Se ha creado la publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado una publicación",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetPublicacionDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                 {
                                                                       "imageURL": "http://localhost:8080/download/logo_416933.PNG",
                                                                       "descripcion": "¡Jugando con mis hermanos!",
                                                                       "fechaRegistro": "2025-02-25",
                                                                       "usuario": {
                                                                           "username": "user3",
                                                                           "email": "user3@example.com",
                                                                           "fechaRegistro": "2025-02-03"
                                                                       },
                                                                       "mascotaDTO": {
                                                                           "nombre": "Milo",
                                                                           "biografia": "Un pez dorado que adora nadar.",
                                                                           "fechaNacimiento": "2023-01-15",
                                                                           "avatar": "logo_416933.PNG",
                                                                           "raza": {
                                                                               "nombre": "Beagle"
                                                                           },
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
                                                                   }
                                                              """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "No se ha podido crear la publicación",
                        content = @Content)
                ,
                @ApiResponse(responseCode = "401",
                        description = "No tienes autorización",
                        content = @Content)
        })
        @PostMapping("/{mascotaId}")
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        public ResponseEntity<GetPublicacionDTO> create(@RequestPart("file") MultipartFile file, @RequestPart("post") CreatePublicacionDTO newPost,
                                                        @AuthenticationPrincipal Usuario usuario, @PathVariable UUID mascotaId
        ) {
            Publicacion publicacion = publicacionService.save(newPost,file, usuario, mascotaId);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(GetPublicacionDTO.of(publicacion, getImageUrl(publicacion.getImage())));
        }

        public String getImageUrl(String filename) {
            return ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(filename)
                    .toUriString();
        }

        @Operation(summary = "Eliminar una publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "Publicación eliminada correctamente",
                        content = @Content
                ),
                @ApiResponse(responseCode = "401",
                        description = "No estás autorizado",
                        content = @Content)
        })
        @DeleteMapping("/{id}")
        @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
        public ResponseEntity<?> deletePublicacion(@PathVariable UUID id, @AuthenticationPrincipal Usuario usuario){
            publicacionService.deleteById(id, usuario);
            return ResponseEntity.noContent().build();
        }


        @Operation(summary = "Editar datos de una publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Publicación editada correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = EditPublicacionDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                             {
                                                                              "imageURL": "Image",
                                                                              "descripcion": "En el parque disfrutando",
                                                                              "fechaRegistro": "2025-02-22",
                                                                              "usuario": {
                                                                                  "username": "user3",
                                                                                  "email": "candicalado@gmail.com",
                                                                                  "fechaRegistro": "2025-02-03"
                                                                              },
                                                                              "mascotaDTO": {
                                                                                  "nombre": "Rocky",
                                                                                  "biografia": "Beagle aventurero y curioso.",
                                                                                  "fechaNacimiento": "2021-01-10",
                                                                                  "avatar": "Image",
                                                                                  "raza": {
                                                                                      "nombre": "Beagle"
                                                                                  },
                                                                                  "especie": {
                                                                                      "nombre": "Canino",
                                                                                      "localDate": "2025-01-01"
                                                                                  },
                                                                                  "userDTO": {
                                                                                      "username": "user3",
                                                                                      "email": "candicalado@gmail.com",
                                                                                      "fechaRegistro": "2025-02-03"
                                                                                  }
                                                                              }
                                                                          }
                                    """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "No tienes permiso para editar esta publicación",
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
        public GetPublicacionEditDTO edit(@RequestBody EditPublicacionDTO edit, @PathVariable UUID id, @AuthenticationPrincipal Usuario usuari) {
            return GetPublicacionEditDTO.of(publicacionService.edit(edit, id, usuari));

        }


        @Operation(summary = "Elimina cualquier publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "La publicación ha sido eliminado correctamente",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "No se encontró la publicación",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No tienes autorización",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/admin/{publicacionId}")
        public ResponseEntity<Void> deletepublicacionByAdmin(@PathVariable UUID publicacionId) {
            publicacionService.deletePublicacionByAdmin(publicacionId);
            return ResponseEntity.noContent().build();
        }

        @Operation(summary = "Obtiene las publicaciones con nombre, con la raza o especie que hayas buscado",
                parameters = {
                        @Parameter(name = "especie", description = "Nombre de la especie de la mascota (opcional)", required = false, example = "Felino"),
                        @Parameter(name = "raza", description = "Nombre de la raza de la mascota (opcional", required = false, example = "Persa"),
                        @Parameter(name = "nombre", description = "Nombre la mascota (opcional)", required = false, example = "Luna"),
                })
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido las publicaciones deseadas",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = GetMascotaDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                 "contenido": [
                                                                           {
                                                                               "id": "550e8400-e29b-41d4-a716-446655440201",
                                                                               "imageURL": "http://localhost:8080/download/https:/cdn.pixabay.com/photo/2017/11/09/21/41/cat-2934720_1280.jpg",
                                                                               "descripcion": "Luna se escondiÃ³ en una caja hoy, Â¡es tan adorable!",
                                                                               "fechaRegistro": "2025-02-21",
                                                                               "numeroLikes": 2,
                                                                               "numeroComentarios": 3,
                                                                               "comentarioDTOList": [
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440303",
                                                                                       "texto": "Luna en una caja, Â¡quÃ© ternura!",
                                                                                       "fechaRealizada": "2025-02-21",
                                                                                       "userDTO": {
                                                                                           "username": "user1"
                                                                                       }
                                                                                   },
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440304",
                                                                                       "texto": "Â¡Luna es la reina de las cajas!",
                                                                                       "fechaRealizada": "2025-02-22",
                                                                                       "userDTO": {
                                                                                           "username": "user4"
                                                                                       }
                                                                                   },
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440305",
                                                                                       "texto": "Â¿CÃ³mo hace Luna para ser tan adorable?",
                                                                                       "fechaRealizada": "2025-02-23",
                                                                                       "userDTO": {
                                                                                           "username": "user3"
                                                                                       }
                                                                                   }
                                                                               ],
                                                                               "usename": {
                                                                                   "username": "user2"
                                                                               },
                                                                               "hasLike": false,
                                                                               "getMascotaDTOName": {
                                                                                   "nombre": "Luna"
                                                                               }
                                                                           },
                                                                           {
                                                                               "id": "550e8400-e29b-41d4-a716-446655440203",
                                                                               "imageURL": "http://localhost:8080/download/https:/asfec.cat/wp-content/uploads/2019/03/bengali.png",
                                                                               "descripcion": "Nala cazando una pelota en el jardÃ­n.",
                                                                               "fechaRegistro": "2025-02-23",
                                                                               "numeroLikes": 2,
                                                                               "numeroComentarios": 3,
                                                                               "comentarioDTOList": [
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440309",
                                                                                       "texto": "Nala cazando es lo mÃ¡s divertido.",
                                                                                       "fechaRealizada": "2025-02-23",
                                                                                       "userDTO": {
                                                                                           "username": "user3"
                                                                                       }
                                                                                   },
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440310",
                                                                                       "texto": "Â¡QuÃ© Ã¡gil es Nala! Me encanta.",
                                                                                       "fechaRealizada": "2025-02-24",
                                                                                       "userDTO": {
                                                                                           "username": "user2"
                                                                                       }
                                                                                   },
                                                                                   {
                                                                                       "id": "550e8400-e29b-41d4-a716-446655440311",
                                                                                       "texto": "Nala es una cazadora nata.",
                                                                                       "fechaRealizada": "2025-02-24",
                                                                                       "userDTO": {
                                                                                           "username": "user1"
                                                                                       }
                                                                                   }
                                                                               ],
                                                                               "usename": {
                                                                                   "username": "user4"
                                                                               },
                                                                               "hasLike": false,
                                                                               "getMascotaDTOName": {
                                                                                   "nombre": "Nala"
                                                                               }
                                                                           }
                                                                           ]
                                                                """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                        description = "Publicacion no encontrada con esos criterios",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content),
        })
        @GetMapping("/filtro/buscar")
        public ResponseEntity<?> buscarPublicaciones(
                @RequestParam(value = "nombre", required = false) String nombreMascota,
                @RequestParam(value = "especie", required = false) String nombreEspecie,
                @RequestParam(value = "raza", required = false) String nombreRaza,
                @PageableDefault(size = 10) Pageable pageable) {

            Page<Publicacion> publicaciones = publicacionService.filtrarPublicaciones(nombreMascota, nombreEspecie, nombreRaza, pageable);

            List<GetPublicacionDTOConLike> result = publicaciones.stream()
                    .map(p -> {
                        String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                                .path("/download/")
                                .path(p.getImage())
                                .toUriString();
                        return GetPublicacionDTOConLike.of(p, imageUrl, false);
                    })
                    .toList();

            return ResponseEntity.ok().body(Map.of(
                    "contenido", result,
                    "paginasTotales", publicaciones.getTotalPages()
            ));
        }

    }
