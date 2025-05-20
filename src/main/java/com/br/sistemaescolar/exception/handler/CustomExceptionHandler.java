package com.br.sistemaescolar.exception.handler;

import com.br.sistemaescolar.exception.ExceptionResponse;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public static ResponseEntity<ExceptionResponse> handlerAllException(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundEception.class)
    public static ResponseEntity<ExceptionResponse> handlerNotFoundException(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(new Date(), e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
