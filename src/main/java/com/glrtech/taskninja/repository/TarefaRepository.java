package com.glrtech.taskninja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.glrtech.taskninja.entity.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
	List<Tarefa> findByUsuarioId(Long usuarioId);
}
