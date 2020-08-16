package br.com.sigo.normas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigo.normas.models.Consultoria;
import br.com.sigo.normas.models.Norma;
import br.com.sigo.normas.repositories.ConsultoriaRepository;

@Service
public class ConsultoriaService {
	
	@Autowired
	private ConsultoriaRepository consultRepo;
	
	
	public Consultoria obterConsultoriaPorId(Long id) {
		return consultRepo.obterConsultoriaPorId(id);
	}


	public void obterDescricaoPorId(Norma n) {
		Consultoria c = consultRepo.obterConsultoriaPorId(n.getConsultoria());
		n.setConsultoriaDesc(c.getDescricao());
	}
	
	
	
	

}
