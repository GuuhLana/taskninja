package com.glrtech.taskninja.dto;

import com.glrtech.taskninja.entity.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String login;
	private String senha;

	public UsuarioDTO(Usuario usuario) {
	}

	public UsuarioDTO() {
	}

	public Usuario criarUsuario() {
		return new Usuario(nome, login, senha);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
