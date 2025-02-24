    package com.candi.animalia.controller;

    import com.candi.animalia.dto.mascota.CreateMascotaDTO;
    import com.candi.animalia.dto.mascota.EditMascotaDTO;
    import com.candi.animalia.dto.mascota.GetMascotaDTO;
    import com.candi.animalia.dto.publicacion.CreatePublicacionDTO;
    import com.candi.animalia.dto.publicacion.EditPublicacionDTO;
    import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
    import com.candi.animalia.dto.publicacion.GetPublicacionEditDTO;
    import com.candi.animalia.model.*;
    import com.candi.animalia.service.EspecieService;
    import com.candi.animalia.service.MascotaService;
    import com.candi.animalia.service.PublicacionService;
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
                        description = "No se ha encontrado ninguna publicación",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content),
        })
        @GetMapping()
        @PostAuthorize("hasRole('ADMIN')")
        public Page<GetPublicacionDTO> getAll(@PageableDefault(page=0, size=5) Pageable pageable) {
            Page<Publicacion> publicacions = publicacionService.findAll(pageable);
            return publicacions.map(p -> {
                return GetPublicacionDTO.of(p, getImageUrl(p.getImage()));
            });
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
                                                                       "usuario": {
                                                                           "username": "user1",
                                                                           "email": "user1@example.com",
                                                                           "fechaRegistro": "2025-02-01"
                                                                       },
                                                                       "mascotaDTO": {
                                                                           "nombre": "Max",
                                                                           "biografia": "Un perro muy juguetón y amigable.",
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
        public GetPublicacionDTO findByid(@PathVariable UUID id){

            Publicacion publicacion = publicacionService.findById(id);
            return GetPublicacionDTO.of(publicacion, getImageUrl(publicacion.getImage()));
        }


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
                                              "titulo":"Nuevo Título",
                                              "descripcion":"Nueva Descripción",
                                              "categoria": {"id": 1}
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
        public GetPublicacionEditDTO edit(@RequestPart("post") @Valid EditPublicacionDTO edit, @PathVariable UUID id, @AuthenticationPrincipal Usuario usuari) {
            return GetPublicacionEditDTO.of(publicacionService.edit(edit, id, usuari));

        }


    }
