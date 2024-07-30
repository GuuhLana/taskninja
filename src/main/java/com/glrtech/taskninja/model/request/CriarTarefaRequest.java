package com.glrtech.taskninja.model.request;

import com.glrtech.taskninja.enums.Prioridade;
import com.glrtech.taskninja.enums.Status;

public class CriarTarefaRequest {
	private String nomeTarefa;
	private String observacao;
	private Status status;
	private Prioridade prioridade;
	private Long usuarioId;

	public CriarTarefaRequest(String nomeTarefa, String observacao, Status status, Prioridade prioridade,
			Long usuarioId) {
		this.nomeTarefa = nomeTarefa;
		this.observacao = observacao;
		this.status = status;
		this.prioridade = prioridade;
		this.usuarioId = usuarioId;
	}

	public CriarTarefaRequest() {
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}
}
