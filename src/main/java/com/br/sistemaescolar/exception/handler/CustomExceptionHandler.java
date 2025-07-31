package com.br.sistemaescolar.exception.handler;

import com.br.sistemaescolar.exception.ClassWithStudentsException;
import com.br.sistemaescolar.exception.exceptionresponse.ExceptionResponse;
import com.br.sistemaescolar.exception.ResourceNotFoundEception;
import com.br.sistemaescolar.exception.exceptionresponse.ExceptionResponseValidate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class CustomExceptionHandler{

    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String dateFormated = now.format(formatter);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllException(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(dateFormated, e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundEception.class)
    public final ResponseEntity<ExceptionResponse> handlerNotFoundException(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(dateFormated, e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClassWithStudentsException.class)
    public final ResponseEntity<ExceptionResponse> handlerClassWithStudents(Exception e, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(dateFormated, e.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<ExceptionResponseValidate> handlerValidateException(MethodArgumentNotValidException ex){
        List<String> erros = new ArrayList<>();

        for(FieldError erro : ex.getBindingResult().getFieldErrors()){
            String details = erro.getField() + " : " + erro.getDefaultMessage();
            erros.add(details);
        }
        ExceptionResponseValidate response = new ExceptionResponseValidate(dateFormated, "Validation error", erros);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
