package com.todolist.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.todolist.todolist.entity.Tarefa;
import com.todolist.todolist.entity.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testeCriarUsuario() {
		var usuario = new Usuario("Eduardo");

		webTestClient
			.post()
			.uri("/usuarios")
			.bodyValue(usuario)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			.jsonPath("$").isMap()
			.jsonPath("$.length()").isEqualTo(3)
			.jsonPath("$.nome").isEqualTo(usuario.getNome());
	}
	
	@Test
	void testeCriarTarefa() {
		Usuario usuario = new Usuario("Eduardo");
		var tarefa = new Tarefa("Tarefa 1", usuario);

		webTestClient
			.post()
			.uri("/tarefas")
			.bodyValue(tarefa)
			.exchange()
			.expectStatus().isCreated()
			.expectBody()
			.jsonPath("$").isMap()
			.jsonPath("$.length()").isEqualTo(2)
			.jsonPath("$.descricao").isEqualTo(tarefa.getDescricao());
		}
}
