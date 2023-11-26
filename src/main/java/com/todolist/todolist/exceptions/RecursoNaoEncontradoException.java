package com.todolist.todolist.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException{
    
    public RecursoNaoEncontradoException() {
        super("Recurso não encontrado");
    }
}
