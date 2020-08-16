package br.com.sigo.monitorvendas.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigo.monitorvendas.models.ModelRetorno;

@RestController
@RequestMapping("/sales/v1")
public class VendasController {
	
	//@CrossOrigin("*")
	@GetMapping("/")
	public ResponseEntity<?> obterMonitor() {
		
		ModelRetorno retorno = new ModelRetorno();
		
		return ResponseEntity.ok(retorno);
	}

}
