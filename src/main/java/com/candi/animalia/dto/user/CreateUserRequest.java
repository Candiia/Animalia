package com.candi.animalia.dto.user;

public record CreateUserRequest(
        String username,
        String email,
        String password,
        String verifyPassword
) {
}
