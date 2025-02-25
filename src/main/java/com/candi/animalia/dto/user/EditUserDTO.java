package com.candi.animalia.dto.user;

import com.candi.animalia.validation.FieldsValueMatch;
import jakarta.validation.constraints.NotBlank;

@FieldsValueMatch.List({
        @FieldsValueMatch(
                field = "password",
                fieldMatch = "verifyPassword",
                message = "Los valores de la contraseña y repetir contraseña no coinciden"),
})
public record EditUserDTO(

        @NotBlank(message = "{editUserRequest.email.notblank}")
        String email,
        String password,
        String verifyPassword
) {
}
