    package com.candi.animalia.controller;

    import com.candi.animalia.dto.mascota.CreateMascotaDTO;
    import com.candi.animalia.dto.mascota.EditMascotaDTO;
    import com.candi.animalia.dto.mascota.GetMascotaDTO;
    import com.candi.animalia.dto.publicacion.GetPublicacionDTO;
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
    import org.springframework.http.ResponseEntity;
    import org.springframework.security.access.prepost.PostAuthorize;
    import org.springframework.security.access.prepost.PreAuthorize;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.web.bind.annotation.*;

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
            return publicacions.map(GetPublicacionDTO::of);
        }




    }
