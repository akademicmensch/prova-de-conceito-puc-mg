package br.com.sigo.consultorias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigo.consultorias.models.Norma;
import br.com.sigo.consultorias.models.Status;
import br.com.sigo.consultorias.repositories.StatusRepository;

@Service
public class StatusService {
	
	@Autowired
	private StatusRepository statusRepo;
	
	public List<Status> obterTodosOsStatus(){
		return statusRepo.buscartodasAsOperacoes();
	}

	public Status searchInativeStatus() {
		return statusRepo.searchInativeStatus();
	}

	public void obterDescricaoPorId(Norma n) {
		Status s = statusRepo.obterStatusPorId(n.getStatus());
		n.setStatusDesc(s.getDescricao());
	}

	public String obterDescricaoPorId(Long status) {
		Status s = statusRepo.obterStatusPorId(status);
		String desc = s.getDescricao();
		return desc;
	}
	
}
