package br.com.sigo.processos.industriais.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.consumingwebservice.wsdl.GetAllProcessesResponse;
import com.example.consumingwebservice.wsdl.GetAllProcessesResponse.Process;
import com.example.consumingwebservice.wsdl.GetProcessResponse;

import br.com.sigo.processos.industriais.client.ProcessClient;
import br.com.sigo.processos.industriais.models.Detalhe;
import br.com.sigo.processos.industriais.models.ProcessoIndustrial;

@RestController
@RequestMapping("/industrialProcess/v1")
public class ProcessosIndustriaisController {
	
	@Autowired ProcessClient processClient;

	//@CrossOrigin("*")
	@GetMapping("/")
	public ResponseEntity<?> obterProcessosIndustriais(){
		
		GetAllProcessesResponse allProcessesResponse = processClient.getAllProcessesResponse("a");
		
		List<ProcessoIndustrial> retorno = new ArrayList<>();
		
		retorno = parseSOAPtoREST(allProcessesResponse);
		
		return ResponseEntity.ok(retorno);
	}
	
	//@CrossOrigin("*")
	@GetMapping("/{id}")
	public ResponseEntity<?> obterProcessoIndustrial(@PathVariable("id") String id){
		
		id = parseIdIntoName(id);
		
		GetProcessResponse presponse = processClient.getProcessResponse(id);
		ProcessoIndustrial retorno = new ProcessoIndustrial();
		
		retorno = parseSAOPtoRESTid(presponse);
		
		return ResponseEntity.ok(retorno);
	}

	private String parseIdIntoName(String id) {
		String retorno = "";
		if(id.equalsIgnoreCase("1")) {
			retorno = "Verificacao de linha de producao";
		}else if(id.equalsIgnoreCase("2")) {
			retorno = "Preparacao da Materia Prima";
		}else if(id.equalsIgnoreCase("3")) {
			retorno = "Fiacao";
		}else if(id.equalsIgnoreCase("4")) {
			retorno = "Tecelagem e Tricolagem";
		}else if(id.equalsIgnoreCase("5")) {
			retorno = "Preparacao para o tingimento";
		}else if(id.equalsIgnoreCase("6")) {
			retorno = "Tingimento";
		}else if(id.equalsIgnoreCase("7")) {
			retorno = "Estamparia";
		}else if(id.equalsIgnoreCase("8")) {
			retorno = "Acabamentos Quimicos";
		}else if(id.equalsIgnoreCase("9")) {
			retorno = "Acabamentos Mecanicos";
		}else if(id.equalsIgnoreCase("10")) {
			retorno = "Confeccao";
		}
		return retorno;
	}

	private ProcessoIndustrial parseSAOPtoRESTid(GetProcessResponse pr) {
		ProcessoIndustrial ret = new ProcessoIndustrial();
		Detalhe d = new Detalhe();
		
		ret.setNome(pr.getProcess().getName());
		ret.setId(pr.getProcess().getId());
		ret.setQuantidadePessoas(String.valueOf(pr.getProcess().getPeopleEnvolved()));
		ret.setProvisorio(pr.getProcess().getSite());
		d.setEtapa1(pr.getProcess().getDetail().getStep1());
		d.setEtapa2(pr.getProcess().getDetail().getStep2());
		d.setEtapa3(pr.getProcess().getDetail().getStep3());
		d.setEtapa4(pr.getProcess().getDetail().getStep4());
		d.setEtapa5(pr.getProcess().getDetail().getStep5());
		d.setEtapa6(pr.getProcess().getDetail().getStep6());
		d.setEtapa7(pr.getProcess().getDetail().getStep7());
		d.setEtapa8(pr.getProcess().getDetail().getStep8());
		d.setEtapa9(pr.getProcess().getDetail().getStep9());
		d.setEtapa10(pr.getProcess().getDetail().getStep10());
		
		ret.setDetalhe(d);
		
		return ret;
	}

	private List<ProcessoIndustrial> parseSOAPtoREST(GetAllProcessesResponse allProcessesResponse) {
		List<ProcessoIndustrial> retorno = new ArrayList<>();
		List<Process> process = allProcessesResponse.getProcess();
		for (Process pr : process) {
			ProcessoIndustrial p = new ProcessoIndustrial();
			p.setId(pr.getProcess().getId());
			p.setNome(pr.getProcess().getName());
			p.setProvisorio(pr.getProcess().getSite());
			p.setQuantidadePessoas(String.valueOf(pr.getProcess().getPeopleEnvolved()));
			Detalhe d = new Detalhe();
			d.setEtapa1(pr.getProcess().getDetail().getStep1());
			d.setEtapa2(pr.getProcess().getDetail().getStep2());
			d.setEtapa3(pr.getProcess().getDetail().getStep3());
			d.setEtapa4(pr.getProcess().getDetail().getStep4());
			d.setEtapa5(pr.getProcess().getDetail().getStep5());
			d.setEtapa6(pr.getProcess().getDetail().getStep6());
			d.setEtapa7(pr.getProcess().getDetail().getStep7());
			d.setEtapa8(pr.getProcess().getDetail().getStep8());
			d.setEtapa9(pr.getProcess().getDetail().getStep9());
			d.setEtapa10(pr.getProcess().getDetail().getStep10());
			
			p.setDetalhe(d);
			retorno.add(p);
			
		}
		return retorno;
	}
	
}
