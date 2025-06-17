package com.candi.animalia.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RazaConMascotaException extends RuntimeException {
    public RazaConMascotaException(String message) {
        super(message);
    }
}
