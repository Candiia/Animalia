package com.candi.animalia.dto.user;

import com.candi.animalia.model.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record UserResponse(
        UUID id,
        String username,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String token,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        String refreshToken,
        Set<String> roles

) {

    public static UserResponse of (Usuario user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                null,
                null,
                user.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet())
        );
    }

    public static UserResponse of (Usuario user, String token, String refreshToken) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                token,
                refreshToken,
                user.getRoles().stream()
                        .map(Enum::name)
                        .collect(Collectors.toSet())
        );
    }

}
