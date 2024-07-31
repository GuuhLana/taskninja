package com.glrtech.taskninja.dto;

import java.time.LocalDateTime;

import com.glrtech.taskninja.enums.Prioridade;
import com.glrtech.taskninja.enums.Status;

public class TarefaDTO {

	private String nomeTarefa;
	private String observacao;
	private Status status;
	private Prioridade prioridade;
	private LocalDateTime dataInicio;
	private LocalDateTime dataFim;
	private Long usuarioId;

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

	public LocalDateTime getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDateTime getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDateTime dataFim) {
		this.dataFim = dataFim;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long Long) {
		this.usuarioId = Long;
	}

}
