package com.candi.animalia.controller;
import com.candi.animalia.dto.paginacion.PaginacionDto;
import com.candi.animalia.dto.raza.GetRazaDTO;
import com.candi.animalia.dto.user.*;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.repository.UsuarioRepository;
import com.candi.animalia.security.jwt.access.JwtService;
import com.candi.animalia.security.jwt.refresh.RefreshToken;
import com.candi.animalia.security.jwt.refresh.RefreshTokenRequest;
import com.candi.animalia.security.jwt.refresh.RefreshTokenService;
import com.candi.animalia.service.UserService;
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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@Tag(name = "Usuario", description = "Controlador de usuario, para realizar todas las operaciones de gestión")
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;

    @Operation(summary = "Creación de un nuevo usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha creado un usuario",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CreateUserRequest.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                    {
                                                        "id": "3da37c63-40f2-4114-9fb5-499767f83f5e",
                                                        "username": "lucialp"
                                                    }
                                                """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No tienes autorización",
                    content = @Content)
    })
    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid CreateUserRequest createUserRequest) {
        Usuario user = userService.createUser(createUserRequest);
        System.out.println(user.getActivationToken());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }

    @Operation(summary = "Login de un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha loggeado un usuario",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                   {
                                                      "id": "c68b1d2a-6d4c-42eb-865e-c4698d3ce934",
                                                      "username": "ss",
                                                      "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjNjhiMWQyYS02ZDRjLTQyZWItODY1ZS1jNDY5OGQzY2U5MzQiLCJpYXQiOjE3NDAxNDAxMjUsImV4cCI6MTc0MDE0MDE4NX0.5n1Wm5vrW8OJBoavqw6E2b_K12iwgkz93vSbLYVQWQD8DPrdsjE0A_PElv7jZtUy",
                                                      "refreshToken": "305f5679-f426-448b-8742-6f689b661b4e"
                                                   }
                                                """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No tienes autorización",
                    content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.username(),
                                loginRequest.password()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Usuario user = (Usuario) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);

        RefreshToken refreshToken = refreshTokenService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken, refreshToken.getToken()));

    }

    @PostMapping("/refresh/token")
    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest req) {
        String token = req.refreshToken();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(refreshTokenService.refreshToken(token));

    }

    @Operation(summary = "Login de un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha loggeado un usuario",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                    {
                                                       "id": "4540ee3e-f455-43d9-a800-0fdfba303892",
                                                       "username": "asss"
                                                    }
                                                """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "404",
                    description = "El código de activación no existe o ha caducado",
                    content = @Content)
    })
    @PostMapping("/activate/account/")
    public ResponseEntity<?> activateAccount(@RequestBody ActivateAccountRequest req) {
        String token = req.token();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(userService.activateAccount(token)));
    }

    @Operation(summary = "Registar un administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha registrado un administrador",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = CreateUserRequest.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                    {
                                                        "id": "3da37c63-40f2-4114-9fb5-499767f83f5e",
                                                        "username": "lucialp"
                                                    }
                                                """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No tienes autorización",
                    content = @Content)
    })
    @PostMapping("/register/admin")
    public ResponseEntity<UserResponse> registerAdmin(@RequestBody @Valid CreateUserRequest createUserRequest) {
        Usuario user = userService.createAdmin(createUserRequest);
        System.out.println(user.getActivationToken());
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user));
    }


    @Operation(summary = "Login de un administrador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Se ha loggeado un administrador",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = UserResponse.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                   {
                                                      "id": "c68b1d2a-6d4c-42eb-865e-c4698d3ce934",
                                                      "username": "admin",
                                                      "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJjNjhiMWQyYS02ZDRjLTQyZWItODY1ZS1jNDY5OGQzY2U5MzQiLCJpYXQiOjE3NDAxNDAxMjUsImV4cCI6MTc0MDE0MDE4NX0.5n1Wm5vrW8OJBoavqw6E2b_K12iwgkz93vSbLYVQWQD8DPrdsjE0A_PElv7jZtUy",
                                                      "refreshToken": "305f5679-f426-448b-8742-6f689b661b4e"
                                                   }
                                                """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "401",
                    description = "No tienes autorización",
                    content = @Content)
    })
    @PostMapping("/login/admin")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginRequest loginRequest) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                loginRequest.username(),
                                loginRequest.password()
                        )
                );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        Usuario user = (Usuario) authentication.getPrincipal();

        String accessToken = jwtService.generateAccessToken(user);

        RefreshToken refreshToken = refreshTokenService.create(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(UserResponse.of(user, accessToken, refreshToken.getToken()));

    }

    @Operation(summary = "se ha obtenido todos los usuarios")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha obtenido todos los usarios",
                    content = {
                            @Content(mediaType = "application/json",

                                    array = @ArraySchema(schema = @Schema(implementation = GetUserDTO.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                            [
                                                {
                                                                        "numPagina": 0,
                                                                        "tamanioPagina": 5,
                                                                        "elementosEncontrados": 5,
                                                                        "paginasTotales": 1,
                                                                        "contenido": [
                                                                            {
                                                                                "username": "admin",
                                                                                "email": "admin@example.com",
                                                                                "fechaRegistro": "2025-02-05"
                                                                            },
                                                                            {
                                                                                "username": "user1",
                                                                                "email": "user1@example.com",
                                                                                "fechaRegistro": "2025-02-01"
                                                                            },
                                                                            {
                                                                                "username": "user2",
                                                                                "email": "user2@example.com",
                                                                                "fechaRegistro": "2025-02-02"
                                                                            },
                                                                            {
                                                                                "username": "user3",
                                                                                "email": "user3@example.com",
                                                                                "fechaRegistro": "2025-02-03"
                                                                            },
                                                                            {
                                                                                "username": "user4",
                                                                                "email": "user4@example.com",
                                                                                "fechaRegistro": "2025-02-04"
                                                                            }
                                                                        ]
                                                                    }
                                                                ]
                                        """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "404",
            description = "No se ha encontrado ninguna usuario",
            content = @Content),
            @ApiResponse(responseCode = "401",
                    description = "No tienes autorización",
                    content = @Content),
            @ApiResponse(responseCode = "403",
                    description = "No acceso",
                    content = @Content)
    })
    @PostAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public PaginacionDto<GetUserDTO> findAll(@PageableDefault(page=0, size=5) Pageable pageable){
        return PaginacionDto.of(userService.findAll(pageable)
                .map(GetUserDTO::of));
    }

    @Operation(summary = "Obtiene un usuario determinada")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Se ha obtenido al usuario",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = GetUserDTO.class)),
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
                    description = "Usuario no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "401",
                    description = "No autorizado",
                    content = @Content),
            @ApiResponse(responseCode = "403",
                    description = "Acceso denegado",
                    content = @Content),
    })
    @GetMapping("/{id}")
    @PostMapping("hasAnyRole('ADMIN', 'USER')")
    public GetUserDTO findByid(@PathVariable UUID id){
        return GetUserDTO.of(userService.findById(id));
    }


    @Operation(summary = "Editar un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Usuario editado correctamente",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = EditUserDTO.class)),
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                            {
                                             "nombre":"Cocodrilo"
                                            }
                                    """
                                            )
                                    })
                    }),
            @ApiResponse(responseCode = "404",
                    description = "Usuario no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "401",
                    description = "No autorizado",
                    content = @Content)
    })
    @PutMapping("/me")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public GetUserDTO edit(@RequestBody @Valid EditUserDTO edit, @AuthenticationPrincipal Usuario usuario) {
        return GetUserDTO.of(userService.editUser(edit, usuario));
    }

    @Operation(summary = "Eliminar un usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Usuario eliminada correctamente",
                    content = @Content
            ),
            @ApiResponse(responseCode = "401",
                    description = "No estás autorizado",
                    content = @Content)
    })
    @DeleteMapping()
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> deleteUser(@AuthenticationPrincipal Usuario usuario){
        userService.deleteUsuarioCuenta(usuario);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Eliminar cualquier usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204",
                    description = "Usuario eliminada correctamente",
                    content = @Content
            ),
            @ApiResponse(responseCode = "401",
                    description = "No tienes acceso",
                    content = @Content),
            @ApiResponse(responseCode = "403",
                    description = "No estás autorizado",
                    content = @Content)
    })
    @DeleteMapping("/admin/{usuarioId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUserByAdmin(@PathVariable UUID usuarioId){
        userService.deleteUserByAdmin(usuarioId);
        return ResponseEntity.noContent().build();
    }


}
