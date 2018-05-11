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
import br.com.bookmark.model.Doacao;
import br.com.bookmark.repository.DoacaoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class DoacaoService {
	
	@Autowired
	private DoacaoRepository doacaoRepository;

	// Buscar Todos Doacaoes
	@GetMapping("/doacaoes")
	public List<Doacao> getAllDoacaoes() {
	    return doacaoRepository.findAll();
	}
	
	// Criar um Novo Doacao
	@PostMapping("/doacao")
	public Doacao createDoacao(@Valid @RequestBody Doacao doacao) {
	    return doacaoRepository.save(doacao);
	}
	
	// Buscar Doacao por Código  
	@GetMapping("/doacao/{id}")
	public Doacao getDoacaoById(@PathVariable(value = "id") Long doacaoId) {
	    return doacaoRepository.findById(doacaoId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Doacao", "id", doacaoId));
	         
	}
	
	// Editar um Doacao
	@PutMapping("/doacao/{id}")
	public Doacao updateDoacao(@PathVariable(value = "id") Long doacaoId,
	                                        @Valid @RequestBody Doacao doacaoDetails) {

	    Doacao doacao = doacaoRepository.findById(doacaoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Doacao", "id", doacaoId));
	    
	    doacao.setDescricao(doacaoDetails.getDescricao());
	    doacao.setDoador(doacaoDetails.getDoador());
	    doacao.setLivro(doacaoDetails.getLivro());
	    doacao.setStatus(doacaoDetails.getStatus());

	    Doacao updatedDoacao = doacaoRepository.save(doacao);
	    return updatedDoacao;
	}
	
	// Deletar um Doacao
	@DeleteMapping("/doacao/{id}")
	public ResponseEntity<?> deleteDoacao(@PathVariable(value = "id") Long doacaoId) {
	    Doacao doacao = doacaoRepository.findById(doacaoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Doacao", "id", doacaoId));

	    doacaoRepository.delete(doacao);

	    return ResponseEntity.ok().build();
	}


}
