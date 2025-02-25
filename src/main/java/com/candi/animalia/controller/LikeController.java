    package com.candi.animalia.controller;

    import com.candi.animalia.dto.especie.CreateEspecieDTO;
    import com.candi.animalia.dto.especie.EditEspecieDTO;
    import com.candi.animalia.dto.especie.GetEspecieDTO;
    import com.candi.animalia.dto.like.CreateLikeDTO;
    import com.candi.animalia.dto.like.GetLikeDTO;
    import com.candi.animalia.dto.paginacion.PaginacionDto;
    import com.candi.animalia.dto.raza.CreateRazaDTO;
    import com.candi.animalia.model.Especie;
    import com.candi.animalia.model.Like;
    import com.candi.animalia.model.Usuario;
    import com.candi.animalia.service.EspecieService;
    import com.candi.animalia.service.LikesService;
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
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PostAuthorize;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.web.bind.annotation.*;

    import java.util.UUID;


    @RestController
    @RequiredArgsConstructor
    @RequestMapping("/like")
    @Tag(name = "Like", description = "Controlador de likes, para realizar todas las operaciones de gestión")
    public class LikeController {

        private final LikesService likesService;

        @Operation(summary = "Obtiene todas los likes")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas los likes",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetLikeDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                    [
                                                                    {
                                                                        "numPagina": 0,
                                                                        "tamanioPagina": 5,
                                                                        "elementosEncontrados": 3,
                                                                        "paginasTotales": 1,
                                                                        "contenido": [
                                                                            {
                                                                                "fechaRealizada": "2025-02-21",
                                                                                "publicacionDTO": {
                                                                                    "imageURL": "Image",
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
                                                                                "userDTO": {
                                                                                    "username": "user3",
                                                                                    "email": "user3@example.com",
                                                                                    "fechaRegistro": "2025-02-03"
                                                                                }
                                                                            },
                                                                            {
                                                                                "fechaRealizada": "2025-02-23",
                                                                                "publicacionDTO": {
                                                                                    "imageURL": "Image",
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
                                                                                "userDTO": {
                                                                                    "username": "user3",
                                                                                    "email": "user3@example.com",
                                                                                    "fechaRegistro": "2025-02-03"
                                                                                }
                                                                            },
                                                                            {
                                                                                "fechaRealizada": "2025-02-24",
                                                                                "publicacionDTO": {
                                                                                    "imageURL": "Image",
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
                                                                                },
                                                                                "userDTO": {
                                                                                    "username": "user3",
                                                                                    "email": "user3@example.com",
                                                                                    "fechaRegistro": "2025-02-03"
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
                description = "No se ha encontrado ninguna like",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PostAuthorize("hasAnyRole('ADMIN', 'USER')")
        @GetMapping()
        public PaginacionDto<GetLikeDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable, @AuthenticationPrincipal Usuario usuario){
            return  PaginacionDto.of(likesService.findAll(pageable, usuario)
                    .map(GetLikeDTO::of));

        }


        @Operation(summary = "Creación de un nuevo like")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado el like",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = CreateLikeDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                           {
                                                                           "fechaRealizada": "2025-02-25",
                                                                           "publicacionDTO": {
                                                                               "imageURL": "Image",
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
                                                                           "userDTO": {
                                                                               "username": "user3",
                                                                               "email": "user3@example.com",
                                                                               "fechaRegistro": "2025-02-03"
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
                        content = @Content)
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @PostMapping()
        public ResponseEntity<GetLikeDTO> createLike(@RequestBody @Valid CreateLikeDTO likeDTO, @AuthenticationPrincipal Usuario usuario) {
            return ResponseEntity.ok(GetLikeDTO.of(likesService.save(likeDTO, usuario)));
        }

        @Operation(summary = "Elimina un like de una publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "El like ha sido eliminado correctamente",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "No se encontró la publicación o el like",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No tienes autorización",
                        content = @Content)
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @DeleteMapping("/{publicacionId}")
        public ResponseEntity<Void> deleteLike(@PathVariable UUID publicacionId, @AuthenticationPrincipal Usuario usuario) {
            likesService.deleteLike(publicacionId, usuario);
            return ResponseEntity.noContent().build();
        }

    }
