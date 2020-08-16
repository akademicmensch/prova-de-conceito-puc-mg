package br.com.sigo.normas.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.sigo.normas.contracts.NormaContract;
import br.com.sigo.normas.contracts.NormaUpdateContract;
import br.com.sigo.normas.models.Norma;
import br.com.sigo.normas.models.ReponseTypeToPDF;
import br.com.sigo.normas.repositories.NormaRepository;

@Service
public class NormaService {
	
	@Autowired
	private NormaRepository normaRepo;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private ConsultoriaService consultoriaService;

	public void desactiveNorma(String id) {
		normaRepo.desactiveNorma(id);
	}

	public Norma getNormaById(String id) {
		Norma n = normaRepo.getNormaById(id);
		obterDescricoes(n);
		return n;
	}
	
	public void obterDescricoes(Norma n) {
		statusService.obterDescricaoPorId(n);
		categoriaService.obterDescricaoPorId(n);
		consultoriaService.obterDescricaoPorId(n);
	}
	
	public List<Norma> getAllNormas(){
		List<Norma> normas = normaRepo.getAllNormas();
		for (Norma norma : normas) {
			obterDescricoes(norma);
		}
		return normas;
	}

	public List<Norma> getNormasByCategory(String id) {
		return normaRepo.getNormasByCategory(id);
	}

	public List<Norma> getNormaByConsulting(String id) {
		return normaRepo.getNormaByConsulting(id);
	}

	public List<Norma> getVigencyNormas() {
		return normaRepo.getVigencyNormas();
	}

	public int createNorma(NormaContract c) {
		return normaRepo.createNorma(c);
	}

	public int updateNorma(String id, NormaUpdateContract c) {
		return normaRepo.updateNorma(id, c);
	}

	public int UpdatePDF(String id, MultipartFile file) throws IOException {
		return normaRepo.UpdatePDF(id, file);
	}

	public ReponseTypeToPDF getPDF(String id){
		System.out.println("ID chegando do angular: ");
		System.out.println(id);
		ReponseTypeToPDF retorno = new ReponseTypeToPDF();
		retorno.setPdf(normaRepo.getPDF(id));
		System.out.println("RETORNO DA CHAMADA: ");
		System.out.println(retorno);
		System.out.println(retorno.getPdf());
		return retorno;
	}
	

}
