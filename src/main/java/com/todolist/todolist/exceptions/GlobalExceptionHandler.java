package com.todolist.todolist.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(RecursoNaoEncontradoException.class)
    ProblemDetail handleRecursoNaoEncontradoException(RecursoNaoEncontradoException e) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
        problemDetail.setTitle("O recurso que você informou não foi encontrado");
        problemDetail.setDetail("É necessário informar um id válido e que exista. Ex : /usuario/1");
        problemDetail.setProperty("StackTrace", e.getStackTrace());
        problemDetail.setProperty("Categoria", "Plataforma");
        problemDetail.setProperty("TimeStamp", Instant.now());
        return problemDetail;
 
    }
}
