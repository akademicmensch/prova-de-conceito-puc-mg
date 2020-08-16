package br.com.sigo.consultorias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigo.consultorias.models.Categoria;
import br.com.sigo.consultorias.models.Norma;
import br.com.sigo.consultorias.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;

	public void obterDescricaoPorId(Norma n) {
		Categoria a = catRepo.obterCategoriaPorId(n.getCategoria());
		
		
	}

}
