    package com.candi.animalia.controller;

    import com.candi.animalia.dto.comentario.CreateComentarioDTO;
    import com.candi.animalia.dto.comentario.EditComentarioDTO;
    import com.candi.animalia.dto.comentario.GetComentarioDTO;
    import com.candi.animalia.dto.especie.EditEspecieDTO;
    import com.candi.animalia.dto.especie.GetEspecieDTO;
    import com.candi.animalia.dto.like.CreateLikeDTO;
    import com.candi.animalia.dto.like.GetLikeDTO;
    import com.candi.animalia.dto.paginacion.PaginacionDto;
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
                                                                     "numPagina": 0,
                                                                     "tamanioPagina": 5,
                                                                     "elementosEncontrados": 3,
                                                                     "paginasTotales": 1,
                                                                     "contenido": [
                                                                         {
                                                                             "texto": "Â¡Suerte a Rocky en la carrera!",
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
                                                                             "texto": "Rocky es todo un atleta, Â¡increÃ­ble!",
                                                                             "fechaRealizada": "2025-02-24",
                                                                             "userDTO": {
                                                                                 "username": "user4",
                                                                                 "email": "user4@example.com",
                                                                                 "fechaRegistro": "2025-02-04"
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
                description = "No se ha encontrado ningún comentario en la publicación",
                content = @Content)
                , @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PostAuthorize("hasAnyRole('ADMIN', 'USER')")
        @GetMapping("{publicacionId}")
        public PaginacionDto<GetComentarioDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable,@PathVariable UUID publicacionId){
            return  PaginacionDto.of(comentarioService.findAllComentByPublication(pageable, publicacionId)
                    .map(GetComentarioDTO::of));
        }


        @Operation(summary = "Se ha creado el comentario")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201",
                        description = "Se ha creado un comentario",
                        content = {
                                @Content(mediaType = "application/json",

                                        array = @ArraySchema(schema = @Schema(implementation = GetComentarioDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                                  {
                                                                        "texto": "¡Que guapo!",
                                                                        "fechaRealizada": "2025-02-25",
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
                @ApiResponse(responseCode = "404",
                        description = "No se ha podido crear el comentario",
                        content = @Content)
                ,
                @ApiResponse(responseCode = "401",
                description = "No tienes autorización",
                content = @Content)
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @PostMapping("/publicacion/{publicacionId}")
        public ResponseEntity<GetComentarioDTO> createComentario(@PathVariable UUID publicacionId,
                                                                 @RequestBody @Valid CreateComentarioDTO comentarioDTO, @AuthenticationPrincipal Usuario usuario) {
            return ResponseEntity.ok(GetComentarioDTO.of(comentarioService.save(comentarioDTO, usuario, publicacionId)));
        }

        @Operation(summary = "Editar un comentario")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "200",
                        description = "Comentario editado correctamente",
                        content = {
                                @Content(mediaType = "application/json",
                                        array = @ArraySchema(schema = @Schema(implementation = EditComentarioDTO.class)),
                                        examples = {
                                                @ExampleObject(
                                                        value = """
                                                           {
                                                             "texto": "¡Que guapo!",
                                                             "fechaRealizada": "2025-02-25",
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
                @ApiResponse(responseCode = "404",
                        description = "Comentario no encontrado",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No autorizado",
                        content = @Content)
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @PutMapping("/{id}")
        public GetComentarioDTO edit(@RequestBody @Valid EditComentarioDTO edit, @PathVariable UUID id, @AuthenticationPrincipal Usuario usuario) {
            return GetComentarioDTO.of(comentarioService.edit(edit, id, usuario));
        }


        @Operation(summary = "Elimina un comentario de una publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "El comentario ha sido eliminado correctamente",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "No se encontró el comentario",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No tienes autorización",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content)
        })
        @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
        @DeleteMapping("/{comentarioId}")
        public ResponseEntity<Void> deleteComentario(@PathVariable UUID comentarioId, @AuthenticationPrincipal Usuario usuario) {
            comentarioService.deleteComentarioByUser(usuario, comentarioId);
            return ResponseEntity.noContent().build();
        }



        @Operation(summary = "Elimina cualquier comentario de una publicación")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "204",
                        description = "El comentario ha sido eliminado correctamente",
                        content = @Content),
                @ApiResponse(responseCode = "404",
                        description = "No se encontró el comentario",
                        content = @Content),
                @ApiResponse(responseCode = "401",
                        description = "No tienes autorización",
                        content = @Content),
                @ApiResponse(responseCode = "403",
                        description = "Acceso denegado",
                        content = @Content)
        })
        @PreAuthorize("hasRole('ADMIN')")
        @DeleteMapping("/admin/{comentarioId}")
        public ResponseEntity<Void> deleteComentarioByAdmin(@PathVariable UUID comentarioId) {
            comentarioService.deleteComentarioByAdmin(comentarioId);
            return ResponseEntity.noContent().build();
        }
    }
