package br.com.sigo.normas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigo.normas.models.Categoria;
import br.com.sigo.normas.models.Norma;
import br.com.sigo.normas.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository catRepo;

	public void obterDescricaoPorId(Norma n) {
		Categoria a = catRepo.obterCategoriaPorId(n.getCategoria());
		n.setCategoriaDesc(a.getDescricao());
	}

	public List<Categoria> obterCategorias() {
		return catRepo.obterCategorias();
	}

}
