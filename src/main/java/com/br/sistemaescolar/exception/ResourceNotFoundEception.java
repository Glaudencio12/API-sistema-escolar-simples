package com.br.sistemaescolar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundEception extends RuntimeException {
    public ResourceNotFoundEception(String message) {
        super(message);
    }
}
