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

import com.glrtech.taskninja.dto.UsuarioDTO;
import com.glrtech.taskninja.entity.Usuario;
import com.glrtech.taskninja.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Operações -> Usuário Controller")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@Operation(summary = "Realiza o cadastro de um novo usuario")
	@PostMapping(path = "/cadastrar")
	public ResponseEntity<?> criarUsuario(@RequestBody UsuarioDTO dto) {
		try {
			UsuarioDTO usuarioDTO = service.criarUsuario(dto);
			return new ResponseEntity<>(usuarioDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Retorna uma lista com todos os usuários cadastrados")
	@GetMapping
	public ResponseEntity<?> listarUsuarios() {
		try {
			List<Usuario> usuarios = service.listarUsuarios();
			return new ResponseEntity<>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Deleta o usuario com o ID informado")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
		try {
			service.deletarUsuario(id);
			return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@Operation(summary = "Edita o usuário")
	@PutMapping(path = "/editar/{id}")
	public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
		try {
			UsuarioDTO usuarioAtualizado = service.editarUsuario(id, dto);
			return new ResponseEntity<>(usuarioAtualizado, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}