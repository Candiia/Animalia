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
                        description = "Se ha obtenido todas las especies",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetEspecieDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                    [
                                                                        {
                                                                                               "content": [
                                                                                                      {
                                                                                                          "nombre": "Peces",
                                                                                                          "localDate": "2023-01-01"
                                                                                                      },
                                                                                                      {
                                                                                                          "nombre": "Invertebrados",
                                                                                                          "localDate": "2024-06-22"
                                                                                                      },
                                                                                                      {
                                                                                                          "nombre": "Equino",
                                                                                                          "localDate": "2025-02-01"
                                                                                                      },
                                                                                                      {
                                                                                                          "nombre": "Rumiantes",
                                                                                                          "localDate": "2025-01-01"
                                                                                                      },
                                                                                                      {
                                                                                                          "nombre": "Roedores",
                                                                                                          "localDate": "2025-01-01"
                                                                                                      }
                                                                                                  ],
                                                                                                  "pageable": {
                                                                                                      "pageNumber": 1,
                                                                                                      "pageSize": 5,
                                                                                                      "sort": {
                                                                                                          "empty": true,
                                                                                                          "sorted": false,
                                                                                                          "unsorted": true
                                                                                                      },
                                                                                                      "offset": 5,
                                                                                                      "paged": true,
                                                                                                      "unpaged": false
                                                                                                  },
                                                                                                  "last": false,
                                                                                                  "totalElements": 11,
                                                                                                  "totalPages": 3,
                                                                                                  "size": 5,
                                                                                                  "number": 1,
                                                                                                  "sort": {
                                                                                                      "empty": true,
                                                                                                      "sorted": false,
                                                                                                      "unsorted": true
                                                                                                  },
                                                                                                  "first": false,
                                                                                                  "numberOfElements": 5,
                                                                                                  "empty": false
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
        @PostAuthorize("hasRole('USER')")
        @GetMapping("/admin")
        public Page<GetLikeDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable, @AuthenticationPrincipal Usuario usuario){
            Page<Like> likes = likesService.findAll(pageable, usuario);
            return likes.map(GetLikeDTO::of);
        }

    }
