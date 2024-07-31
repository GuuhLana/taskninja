package com.glrtech.taskninja.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.glrtech.taskninja.enums.Prioridade;
import com.glrtech.taskninja.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_TAREFA")
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_tarefa")
	private String nomeTarefa;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "status")
	private Status status;
	
	@Column(name = "prioridade")
	private Prioridade prioridade;
	
	@Column(name = "data_inicio")
	private LocalDateTime dataInicio;
	
	@Column(name = "data_final")
	private LocalDateTime dataFim;

	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	@JsonBackReference
	private Usuario usuario;

	public Tarefa(Long id, String nomeTarefa, String observacao, Status status, Prioridade prioridade,
			LocalDateTime dataInicio, LocalDateTime dataFim, Usuario usuario) {
		super();
		this.id = id;
		this.nomeTarefa = nomeTarefa;
		this.observacao = observacao;
		this.status = status;
		this.prioridade = prioridade;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.usuario = usuario;
	}

	public Tarefa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

}
