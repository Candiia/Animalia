    package com.candi.animalia.controller;

    import com.candi.animalia.dto.comentario.CreateComentarioDTO;
    import com.candi.animalia.dto.comentario.GetComentarioDTO;
    import com.candi.animalia.dto.like.CreateLikeDTO;
    import com.candi.animalia.dto.like.GetLikeDTO;
    import com.candi.animalia.model.Comentario;
    import com.candi.animalia.model.Like;
    import com.candi.animalia.model.Usuario;
    import com.candi.animalia.repository.ComentarioRepository;
    import com.candi.animalia.service.ComentarioService;
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
    @RequestMapping("/comentario")
    @Tag(name = "Comentario", description = "Controlador de comentarios, para realizar todas las operaciones de gestión")
    public class ComentarioController {


        private final ComentarioService comentarioService;

        @Operation(summary = "Obtiene todas los comentarios")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Se ha obtenido todas los comentarios de la publicación",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetComentarioDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                               [
                                                                    {
                                                                         "content": [
                                                                             {
                                                                                 "texto": "¡Suerte a Rocky en la carrera!",
                                                                                 "fechaRealizada": "2025-02-22",
                                                                                 "userDTO": {
                                                                                     "username": "user1",
                                                                                     "email": "user1@example.com",
                                                                                     "fechaRegistro": "2025-02-01"
                                                                                 }
                                                                             },
                                                                             {
                                                                                 "texto": "Rocky va a arrasar este fin de semana.",
                                                                                 "fechaRealizada": "2025-02-23",
                                                                                 "userDTO": {
                                                                                     "username": "user2",
                                                                                     "email": "user2@example.com",
                                                                                     "fechaRegistro": "2025-02-02"
                                                                                 }
                                                                             },
                                                                             {
                                                                                 "texto": "Rocky es todo un atleta, ¡increíble!",
                                                                                 "fechaRealizada": "2025-02-24",
                                                                                 "userDTO": {
                                                                                     "username": "user4",
                                                                                     "email": "user4@example.com",
                                                                                     "fechaRegistro": "2025-02-04"
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
                                                                         "first": true,
                                                                         "size": 5,
                                                                         "number": 0,
                                                                         "sort": {
                                                                             "empty": true,
                                                                             "sorted": false,
                                                                             "unsorted": true
                                                                         },
                                                                         "numberOfElements": 3,
                                                                         "empty": false
                                                                     }
                                                               ]
                                                              """
                                                )
                                        })
                        }),
                @ApiResponse(responseCode = "404",
                description = "No se ha encontrado ningún comentario en la publicación",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PostAuthorize("hasAnyRole('ADMIN', 'USER')")
        @GetMapping("{publicacionId}")
        public Page<GetComentarioDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable,@PathVariable UUID publicacionId){
            Page<Comentario> comentario = comentarioService.findAllComentByPublication(pageable, publicacionId);
            return comentario.map(GetComentarioDTO::of);
        }


        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @PostMapping("/publicacion/{publicacionId}")
        public ResponseEntity<GetComentarioDTO> createLike(@PathVariable UUID publicacionId, @RequestBody @Valid CreateComentarioDTO comentarioDTO, @AuthenticationPrincipal Usuario usuario) {
            return ResponseEntity.ok(GetComentarioDTO.of(comentarioService.save(comentarioDTO, usuario, publicacionId)));
        }

    }
