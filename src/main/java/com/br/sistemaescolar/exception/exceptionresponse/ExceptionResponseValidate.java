package com.br.sistemaescolar.exception.exceptionresponse;
import java.util.List;

public record ExceptionResponseValidate(String timestamp, String message, List<String> details) { }
