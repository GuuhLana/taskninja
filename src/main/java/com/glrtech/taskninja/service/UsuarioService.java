package com.glrtech.taskninja.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
