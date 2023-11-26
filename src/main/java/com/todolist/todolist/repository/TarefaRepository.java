package com.todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
