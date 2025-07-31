package com.br.sistemaescolar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ClassWithStudentsException extends RuntimeException {
    public ClassWithStudentsException(String message) {
        super(message);
    }
}
