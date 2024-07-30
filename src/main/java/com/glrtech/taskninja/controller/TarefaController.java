package com.glrtech.taskninja.controller;

import java.util.List;

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

import com.glrtech.taskninja.dto.TarefaDTO;
import com.glrtech.taskninja.entity.Tarefa;
import com.glrtech.taskninja.model.request.CriarTarefaRequest;
import com.glrtech.taskninja.service.TarefaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Operações -> Tarefa Controller")
@RestController
@RequestMapping("/tarefas")
public class TarefaController {

	@Autowired
	private TarefaService service;

	@Operation(summary = "Cadastra uma nova tarefa")
	@PostMapping("/cadastrar")
	public ResponseEntity<?> criarTarefa(@RequestBody CriarTarefaRequest request) {
		try {
			Tarefa tarefaCriada = service.criarTarefa(request.getNomeTarefa(), request.getObservacao(),
					request.getUsuarioId(), request.getStatus(), request.getPrioridade());
			return new ResponseEntity<>("Tarefa criada com sucesso, id da tarefa: " + tarefaCriada.getId(),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Retorna uma lista com todas as tarefas associadas ao usuário")
	@GetMapping("/{id}")
	public ResponseEntity<?> listarTarefas(@PathVariable Long id) {
		try {
			List<Tarefa> tarefas = service.listarTarefasPorUsuario(id);
			return new ResponseEntity<>(tarefas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Edita a tarefa com o ID informado")
	@PutMapping("/{id}")
	public ResponseEntity<?> editarTarefa(@PathVariable Long id, @RequestBody TarefaDTO tarefaDTO) {
		try {
			Tarefa tarefaAtualizada = service.editarTarefa(id, tarefaDTO);
			return new ResponseEntity<>(tarefaAtualizada, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Deleta a tarefa com o ID informado")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarTarefa(@PathVariable Long id) {
		try {
			service.deletarTarefa(id);
			return new ResponseEntity<>("Tarefa deletada com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
