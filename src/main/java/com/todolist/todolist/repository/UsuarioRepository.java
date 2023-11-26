package com.todolist.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.todolist.todolist.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
