package com.candi.animalia.controller;
import com.candi.animalia.dto.user.ActivateAccountRequest;
import com.candi.animalia.dto.user.CreateUserRequest;
import com.candi.animalia.dto.user.LoginRequest;
import com.candi.animalia.dto.user.UserResponse;
import com.candi.animalia.model.Usuario;
import com.candi.animalia.security.jwt.access.JwtService;
import com.candi.animalia.security.jwt.refresh.RefreshToken;
import com.candi.animalia.security.jwt.refresh.RefreshTokenRequest;
import com.candi.animalia.security.jwt.refresh.RefreshTokenService;
import com.candi.animalia.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequiredArgsConstructor
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
    @PostMapping("/auth/register")
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
    @PostMapping("/auth/login")
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

    @PostMapping("/auth/refresh/token")
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
    @PostMapping("/auth/register/admin")
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
    @PostMapping("/auth/login/admin")
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


}
