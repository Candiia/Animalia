package com.candi.animalia.dto.user;

public record LoginRequest(
        String username,
        String password
) {
}
