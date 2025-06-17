package com.candi.animalia.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EspecieConMascotasException extends RuntimeException {
    public EspecieConMascotasException(String message) {
        super(message);
    }
}
