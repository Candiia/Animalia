    package com.candi.animalia.controller;

    import com.candi.animalia.dto.especie.CreateEspecieDTO;
    import com.candi.animalia.dto.especie.EditEspecieDTO;
    import com.candi.animalia.dto.especie.GetEspecieDTO;
    import com.candi.animalia.dto.like.GetLikeDTO;
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
                                                                    [{
                                                                                                       "content": [
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
                                                                                                       "totalElements": 3,
                                                                                                       "totalPages": 1,
                                                                                                       "size": 5,
                                                                                                       "number": 0,
                                                                                                       "sort": {
                                                                                                           "empty": true,
                                                                                                           "sorted": false,
                                                                                                           "unsorted": true
                                                                                                       },
                                                                                                       "first": true,
                                                                                                       "numberOfElements": 3,
                                                                                                       "empty": false
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
        @PostAuthorize("hasRole('USER')")
        @GetMapping("/admin")
        public Page<GetLikeDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable, @AuthenticationPrincipal Usuario usuario){
            Page<Like> likes = likesService.findAll(pageable, usuario);
            return likes.map(GetLikeDTO::of);
        }

    }
