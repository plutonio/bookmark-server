package br.com.bookmark.service;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RestController;

import br.com.bookmark.exception.ResourceNotFoundException;
import br.com.bookmark.model.Leitor;
import br.com.bookmark.repository.LeitorRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LeitorService {

	@Autowired
	private LeitorRepository leitorRepository;

	// Buscar Todos Leitores
	@GetMapping("/leitores")
	public List<Leitor> getAllLeitores() {
	    return leitorRepository.findAll();
	}
	
	// Criar um Novo Leitor
	@PostMapping("/leitor")
	public Leitor createLeitor(@Valid @RequestBody Leitor leitor) {
	    return leitorRepository.save(leitor);
	}
	
	// Buscar Leitor por Código  
	@GetMapping("/leitor/{id}")
	public Leitor getLeitorById(@PathVariable(value = "id") Long leitorId) {
	    return leitorRepository.findById(leitorId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Leitor", "id", leitorId));
	         
	}
	
	// Editar um Leitor
	@PutMapping("/leitor/{id}")
	public Leitor updateLeitor(@PathVariable(value = "id") Long leitorId,
	                                        @Valid @RequestBody Leitor leitorDetails) {

	    Leitor leitor = leitorRepository.findById(leitorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Leitor", "id", leitorId));
	    
	    leitor.setNome(leitorDetails.getNome());
	    leitor.setSenha(leitorDetails.getSenha());
	    leitor.setCidade(leitorDetails.getCidade());
	    leitor.setEstado(leitorDetails.getEstado());
	    leitor.setEmail(leitorDetails.getEmail());

	    Leitor updatedLeitor = leitorRepository.save(leitor);
	    return updatedLeitor;
	}
	
	// Deletar um Leitor
	@DeleteMapping("/leitor/{id}")
	public ResponseEntity<?> deleteLeitor(@PathVariable(value = "id") Long leitorId) {
	    Leitor leitor = leitorRepository.findById(leitorId)
	            .orElseThrow(() -> new ResourceNotFoundException("Leitor", "id", leitorId));

	    leitorRepository.delete(leitor);

	    return ResponseEntity.ok().build();
	}

}
