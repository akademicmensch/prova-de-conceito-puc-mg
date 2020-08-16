package br.com.sigo.consultorias.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigo.consultorias.contracts.ContratarContract;
import br.com.sigo.consultorias.models.Consultoria;
import br.com.sigo.consultorias.models.ProrrogarContrato;
import br.com.sigo.consultorias.services.ConsultoriaService;
import br.com.sigo.consultorias.util.Util;

@RestController
@RequestMapping(value = "/consultorias/v1")
public class ConsultoriasController {
	
	@Autowired
	private ConsultoriaService consultoriaService;
	
	//@CrossOrigin("*")
	@GetMapping("/")
	public ResponseEntity<?> getTodasAsConsultorias(@RequestParam(value = "status", required = false) String status) {
		List<Consultoria> retorno = new ArrayList<>();
		if(Util.isThereStatus(status)) {
			String[] statusSeparado = status.split(":");
			statusSeparado = Util.validaStatusSeparado(statusSeparado);
			switch(statusSeparado[0]) {
			case "processo": retorno = consultoriaService.obterConsultoriasPorFiltro(statusSeparado);
				break;
			case "status": retorno = consultoriaService.obterConsultoriasPorFiltro(statusSeparado);
				break;
			case "data": retorno = consultoriaService.obterConsultoriasPorFiltro(statusSeparado);
				break;
			case "cnpj": retorno = consultoriaService.obterConsultoriasPorFiltro(statusSeparado);
				break;
			default:
				return ResponseEntity.noContent().build();
			}
		}else {
			retorno = consultoriaService.obterTodasAsConsultorias();
		}
		return ResponseEntity.ok(retorno);
	}
	
	
	
	//@CrossOrigin("*")
	@GetMapping("/{id}")
	public ResponseEntity<?> getConsultoriaById(@PathVariable("id") String id) {
		Long idT = new Long(id);
		Consultoria conusltoria = consultoriaService.obterConsultoriaPorId(idT);
		if(conusltoria != null) {
			return ResponseEntity.ok(conusltoria);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//@CrossOrigin("*")
	@PostMapping("/")
	public ResponseEntity<?> contratarConsultoria(@RequestBody ContratarContract c) throws ParseException{
		int contratarConsultoria = consultoriaService.contratarConsultoria(c);
		if(contratarConsultoria==1) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	//@CrossOrigin("*")
	@PutMapping("/{id}")
	public ResponseEntity<?> prorrogarContratoConsultoria(@PathVariable("id") String id, @RequestBody ProrrogarContrato p) throws ParseException{
		int i = consultoriaService.prorrogarContratoConsultoria(id, p);
		if(i == 1) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//@CrossOrigin("*")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> finalizarContratoConsultoria(@PathVariable("id") String id){
		int i = consultoriaService.finalizarContratoConsultoria(id);
		if(i == 1) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
