package com.candi.animalia.dto.user;

import com.candi.animalia.validation.FieldsValueMatch;
import com.candi.animalia.validation.UniqueUsername;
import jakarta.validation.constraints.NotBlank;
@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Los valores de la contraseña y repetir contraseña no coinciden"),
})
public record CreateUserRequest(
        @UniqueUsername
        String username,

        @NotBlank(message = "{createUserRequest.email.notblank}")
        String email,
        String password,
        String verifyPassword
) {
}
