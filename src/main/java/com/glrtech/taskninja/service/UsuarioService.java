package com.glrtech.taskninja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glrtech.taskninja.dto.UsuarioDTO;
import com.glrtech.taskninja.entity.Usuario;
import com.glrtech.taskninja.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;

	public List<Usuario> listarUsuarios() {
		List<Usuario> listaUsuarios = repository.findAll();
		return listaUsuarios;
	}

	public UsuarioDTO criarUsuario(UsuarioDTO dto) {

		Usuario usuario = dto.criarUsuario();

		boolean existeLoginUsuario = repository.existsByLogin(usuario.getLogin());

		if (existeLoginUsuario) {
			throw new RuntimeException("Já existe um usuario cadastrado com o login fornecido!");
		} else {
			repository.save(usuario);
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);

			return usuarioDTO;
		}
	}

	public boolean deletarUsuario(Long id) {

		boolean existeUsuario = repository.existsById(id);

		if (existeUsuario) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public UsuarioDTO editarUsuario(Long id, UsuarioDTO dto) {
		Usuario usuario = repository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		usuario.setNome(dto.getNome());
		usuario.setLogin(dto.getLogin());
		usuario.setSenha(dto.getSenha());

		Usuario usuarioAtualizado = repository.save(usuario);
		return new UsuarioDTO(usuarioAtualizado);
	}

}
