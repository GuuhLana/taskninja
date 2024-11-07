package com.glrtech.taskninja.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glrtech.taskninja.dto.TarefaDTO;
import com.glrtech.taskninja.entity.Tarefa;
import com.glrtech.taskninja.entity.Usuario;
import com.glrtech.taskninja.enums.Prioridade;
import com.glrtech.taskninja.enums.Status;
import com.glrtech.taskninja.repository.TarefaRepository;
import com.glrtech.taskninja.repository.UsuarioRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Tarefa> listarTarefasPorUsuario(Long usuarioId) {
		return tarefaRepository.findByUsuarioId(usuarioId);
	}

	public Tarefa obterTarefaPorId(Long id) {
		return tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
	}

	public Tarefa criarTarefa(String nomeTarefa, String observacaoTarefa, Long idUsuario, Status status,
			Prioridade prioridade) {
		Usuario usuario = usuarioRepository.findById(idUsuario)
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		Tarefa tarefa = new Tarefa();
		tarefa.setNomeTarefa(nomeTarefa);
		tarefa.setObservacao(observacaoTarefa);
		tarefa.setStatus(status);
		tarefa.setPrioridade(prioridade);
		tarefa.setDataInicio(LocalDateTime.now());
		tarefa.setDataFim(null);
		tarefa.setUsuario(usuario);

		return tarefaRepository.save(tarefa);
	}

	public void deletarTarefa(Long id) {
		if (!tarefaRepository.existsById(id)) {
			throw new RuntimeException("Tarefa não encontrada");
		}
		tarefaRepository.deleteById(id);
	}

	public Tarefa editarTarefa(Long id, TarefaDTO tarefaDTO) {
		Tarefa tarefa = tarefaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));

		// Verificar se o usuário existe
		Usuario usuario = usuarioRepository.findById(tarefaDTO.getUsuarioId())
				.orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

		// Atualizar a tarefa
		tarefa.setNomeTarefa(tarefaDTO.getNomeTarefa());
		tarefa.setObservacao(tarefaDTO.getObservacao());
		tarefa.setStatus(tarefaDTO.getStatus());
		tarefa.setPrioridade(tarefaDTO.getPrioridade());
		tarefa.setDataInicio(tarefaDTO.getDataInicio());
		tarefa.setDataFim(tarefaDTO.getDataFim());
		tarefa.setUsuario(usuario);

		// Salvar a tarefa atualizada no banco de dados
		return tarefaRepository.save(tarefa);
	}

	public void concluirTarefa(Long id) {
		
		Tarefa tarefa = obterTarefaPorId(id);
		tarefa.setStatus(Status.CONCLUIDO);
		
		tarefaRepository.save(tarefa);
		
		return;
	}
}
