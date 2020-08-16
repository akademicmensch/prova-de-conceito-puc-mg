package br.com.sigo.consultorias.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sigo.consultorias.contracts.ContratarContract;
import br.com.sigo.consultorias.models.Consultoria;
import br.com.sigo.consultorias.models.Norma;
import br.com.sigo.consultorias.models.ProrrogarContrato;
import br.com.sigo.consultorias.repositories.ConsultoriaRepository;

@Service
public class ConsultoriaService {
	
	@Autowired
	private ConsultoriaRepository consultRepo;
	
	@Autowired
	private StatusService statusService;
	
	
	public Consultoria obterConsultoriaPorId(Long id) {
		Consultoria ret = consultRepo.obterConsultoriaPorId(id);
		obterStatusDescription(ret);
		return ret;
	}


	public void obterDescricaoPorId(Norma n) {
		Consultoria c = consultRepo.obterConsultoriaPorId(n.getConsultoria());
		n.setConsultoriaDesc(c.getDescricao());
	}


	public int contratarConsultoria(ContratarContract c) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date inicio = sdf.parse(c.getInicioContrato());
		Date fim = sdf.parse(c.getFimContrato());
		
		return consultRepo.contratarConsultoria(c,inicio,fim);
	}


	public List<Consultoria> obterTodasAsConsultorias() {
		List<Consultoria> retorno = new ArrayList<>();
		try {
			retorno = consultRepo.obterTodasAsConsultorias();
			for (Consultoria consultoria : retorno) {
				obterStatusDescription(consultoria);
			}
		}catch(Exception e) {
			
		}
		return retorno;
	}


	public List<Consultoria> obterConsultoriasPorFiltro(String[] status) {
		String querie = obterQuerieDoFiltro(status);
		List<Consultoria> retorno = new ArrayList<>();
		try {
			retorno = consultRepo.obterConsultoriasPorFiltro(querie);
			
			for (Consultoria consultoria : retorno) {
				obterStatusDescription(consultoria);
			}
			
		}catch(Exception e) {}
		
		return retorno;
	}
	
	private void obterStatusDescription(Consultoria consultoria) {
		String desc = statusService.obterDescricaoPorId(consultoria.getStatus());
		consultoria.setStatusDesc(desc);
		
	}


	public String obterQuerieDoFiltro(String[] status) {
		String retorno = "";
		if(status[0].contains("processo")) {
			retorno = " WHERE processo = " + status[1]; 
		}else if(status[0].contains("status")) {
			retorno = " WHERE status = " + status[1];
		}else if(status[0].contains("data")) {
			retorno = " WHERE inicioContrato = x and fimcontrato = y";
		}else if(status[0].contains("cnpj")) {
			retorno = " WHERE cnpj = " + status[1];
		}else {
			retorno = "";
		}
		return retorno;
	}


	public int finalizarContratoConsultoria(String id) {
		return consultRepo.finalizarContratoConsultoria(id);
	}


	public int prorrogarContratoConsultoria(String id, ProrrogarContrato p) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date fimContrato = sdf.parse(p.getFimContrato());
		return consultRepo.prorrogarContratoConsultoria(id, fimContrato);
	}


	
	
	
	

}
