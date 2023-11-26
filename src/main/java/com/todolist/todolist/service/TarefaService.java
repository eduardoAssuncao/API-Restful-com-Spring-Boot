package com.todolist.todolist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todolist.todolist.entity.Tarefa;
import com.todolist.todolist.repository.TarefaRepository;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> getTarefaById(Long id) {
        return tarefaRepository.findById(id);
    }

    public Tarefa createTarefa(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa updateTarefa(Long id, Tarefa tarefa) {
        if (tarefaRepository.existsById(id)) {
            tarefa.setId(id);
            return tarefaRepository.save(tarefa);
        }
        return null; // ou lançar uma exceção, dependendo da sua lógica de negócios
    }

    public void deleteTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }
}
