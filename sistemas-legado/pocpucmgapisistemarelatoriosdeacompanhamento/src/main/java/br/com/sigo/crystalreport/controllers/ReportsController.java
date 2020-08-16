package br.com.sigo.crystalreport.controllers;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sigo.crystalreport.models.Relatorio;
import br.com.sigo.crystalreport.services.GeneratePdf;

@RestController
@RequestMapping("/reports/v1")
public class ReportsController {
	
	//@CrossOrigin("*")
	@GetMapping(value = "/")
	public ResponseEntity<?> obterNomesRelatoriosDisponiveis() {
		List<Relatorio> rel = new ArrayList<>();
		Relatorio a = new Relatorio();a.setTitulo("Relatorio de vendas semestral");a.setId("1");
		Relatorio b = new Relatorio();b.setTitulo("Relatorio de vendas bimestral");b.setId("2");
		Relatorio c = new Relatorio();c.setTitulo("Relatorio de venda por material anual");c.setId("3");
		Relatorio d = new Relatorio();d.setTitulo("Relatorio de compra de insumos trimestral");d.setId("4");
		Relatorio e = new Relatorio();e.setTitulo("Relatorio de compra de equipamentos anual");e.setId("5");
		Relatorio f = new Relatorio();f.setTitulo("Relatorio gerencial consolidado semanal");f.setId("6");
		rel.add(a);rel.add(b);rel.add(c);rel.add(d);rel.add(e);rel.add(f);
		
		return ResponseEntity.ok(rel);
	}
	
	
	@CrossOrigin("*")
	@GetMapping(value = "/{id}",produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<?> obterRelatorioEspecifico(@PathVariable("id") String id){
		
		ByteArrayInputStream bis = GeneratePdf.relatorioSigo(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=report.pdf");

        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
	}
}
