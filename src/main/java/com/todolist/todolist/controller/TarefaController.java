package com.todolist.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.todolist.todolist.entity.Tarefa;
import com.todolist.todolist.service.TarefaService;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;
    @GetMapping
    public ResponseEntity<List<Tarefa>> getAllTarefas() {
        List<Tarefa> listaTarefas = tarefaService.getAllTarefas();
        if (!listaTarefas.isEmpty()) {
            for (Tarefa tarefa : listaTarefas) {
                Long id = tarefa.getId();
                tarefa.add(linkTo(methodOn(TarefaController.class).getTarefaById(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaTarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> getTarefaById(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaService.getTarefaById(id);
        if(tarefa.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(tarefa.get());
        }
        tarefa.get().add(linkTo(methodOn(TarefaController.class).getAllTarefas()).withRel("Lista de tarefas"));
        return ResponseEntity.status(HttpStatus.OK).body(tarefa.get());
    }

    @PostMapping
    public ResponseEntity<Tarefa> createTarefa(@RequestBody Tarefa tarefa) {
        Tarefa savedTarefa = tarefaService.createTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTarefa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        if (!tarefaService.getTarefaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tarefa.setId(id);
        Tarefa updatedTarefa = tarefaService.createTarefa(tarefa);
        return ResponseEntity.ok(updatedTarefa);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tarefa> deleteTarefa(@PathVariable Long id) {
        if (!tarefaService.getTarefaById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }

        tarefaService.deleteTarefa(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Tarefa> deleteAllTarefas() {
        tarefaService.deleteAllTarefas();
        return ResponseEntity.noContent().build();
    }
}
