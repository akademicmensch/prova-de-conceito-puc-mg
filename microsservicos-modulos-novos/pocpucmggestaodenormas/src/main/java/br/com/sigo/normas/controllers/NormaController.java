package br.com.sigo.normas.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import org.springframework.web.multipart.MultipartFile;

import br.com.sigo.normas.contracts.NormaContract;
import br.com.sigo.normas.contracts.NormaUpdateContract;
import br.com.sigo.normas.models.Categoria;
import br.com.sigo.normas.models.Norma;
import br.com.sigo.normas.services.CategoriaService;
import br.com.sigo.normas.services.NormaService;

@RestController
@RequestMapping("/normas/v1")
public class NormaController {
	
	@Autowired
	private NormaService norma;
	
	@Autowired
	private CategoriaService catS;

	//@CrossOrigin("*")
	@GetMapping("/{id}")
	public ResponseEntity<?> getNormaById(@PathVariable("id") String id) {
		Norma normaById = norma.getNormaById(id);
		if(normaById != null) {
			return ResponseEntity.ok(normaById);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@CrossOrigin("*")
	@PostMapping("/{id}/pdf")
	public ResponseEntity<?> updatePDF(@PathVariable("id") String id, @RequestParam("pdf") MultipartFile file) throws IOException{
		if(norma.UpdatePDF(id, file) == 1) {
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@CrossOrigin("*")
	@GetMapping("/{id}/pdf")
	public ResponseEntity<?> getPdf(@PathVariable("id") String id){
		return ResponseEntity.ok(norma.getPDF(id));
	}
	
	//@CrossOrigin("*")
	@GetMapping("/")
	public ResponseEntity<?> getAllNormas(){
		List<Norma> ret = norma.getAllNormas();
		if(ret != null) {
			return ResponseEntity.ok(ret);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//@CrossOrigin("*")
	@GetMapping("/vingency")
	public ResponseEntity<?> getVigencyNormas(){
		List<Norma> ret = norma.getVigencyNormas();
		if(ret != null) {
			return ResponseEntity.ok(ret);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//@CrossOrigin("*")
	@GetMapping("/category/{id}")
	public ResponseEntity<?> getNormasByCategory(@PathVariable("id") String id){
		List<Norma> ret = norma.getNormasByCategory(id);
		if(ret != null) {
			return ResponseEntity.ok(ret);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//@CrossOrigin("*")
	@GetMapping("/consultory/{id}")
	public ResponseEntity<?> getNormaByConsulting(@PathVariable("id") String id){
		List<Norma> ret = norma.getNormaByConsulting(id);
		if(ret != null) {
			return ResponseEntity.ok(ret);
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	//@CrossOrigin("*")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateNorma(@PathVariable("id") String id, @RequestBody NormaUpdateContract c) {
		if(norma.updateNorma(id, c) == 1) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//@CrossOrigin("*")
	@PostMapping("/")
	public ResponseEntity<?> createNorma(@RequestBody NormaContract c) throws URISyntaxException {
		if(norma.createNorma(c) == 1) {
			return ResponseEntity.created(new URI(new String("Nova norma criada"))).build();
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	//@CrossOrigin("*")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> desactiveNorma(@PathVariable("id") String id) {
		norma.desactiveNorma(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@GetMapping("/categories")
	public ResponseEntity<?> getCategories() {
		List<Categoria> retorno = catS.obterCategorias();
		return ResponseEntity.ok(retorno);
	}
	
	
	
}
