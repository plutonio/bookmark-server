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
import br.com.bookmark.model.ClubeDoLivro;
import br.com.bookmark.repository.ClubeDoLivroRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ClubeDoLivroService {

	
	@Autowired
	private ClubeDoLivroRepository clubedolivroRepository;

	// Buscar Todos ClubeDoLivroes
	@GetMapping("/clubedolivros")
	public List<ClubeDoLivro> getAllClubeDoLivroes() {
	    return clubedolivroRepository.findAll();
	}
	
	// Criar um Novo ClubeDoLivro
	@PostMapping("/clubedolivro")
	public ClubeDoLivro createClubeDoLivro(@Valid @RequestBody ClubeDoLivro clubedolivro) {
	    return clubedolivroRepository.save(clubedolivro);
	}
	
	// Buscar ClubeDoLivro por Código  
	@GetMapping("/clubedolivro/{id}")
	public ClubeDoLivro getClubeDoLivroById(@PathVariable(value = "id") Long clubedolivroId) {
	    return clubedolivroRepository.findById(clubedolivroId)
	    		.orElseThrow(() -> new ResourceNotFoundException("ClubeDoLivro", "id", clubedolivroId));
	         
	}
	
	// Editar um ClubeDoLivro
	@PutMapping("/clubedolivro/{id}")
	public ClubeDoLivro updateClubeDoLivro(@PathVariable(value = "id") Long clubedolivroId,
	                                        @Valid @RequestBody ClubeDoLivro clubedolivroDetails) {

	    ClubeDoLivro clubedolivro = clubedolivroRepository.findById(clubedolivroId)
	            .orElseThrow(() -> new ResourceNotFoundException("ClubeDoLivro", "id", clubedolivroId));
	    
	    clubedolivro.setNome(clubedolivroDetails.getNome());
	    clubedolivro.setDescricao(clubedolivroDetails.getDescricao());
	    clubedolivro.setCidade(clubedolivroDetails.getCidade());
	    clubedolivro.setEstado(clubedolivroDetails.getEstado());
	    clubedolivro.setMembros(clubedolivroDetails.getMembros());

	    ClubeDoLivro updatedClubeDoLivro = clubedolivroRepository.save(clubedolivro);
	    return updatedClubeDoLivro;
	}
	
	// Deletar um ClubeDoLivro
	@DeleteMapping("/clubedolivro/{id}")
	public ResponseEntity<?> deleteClubeDoLivro(@PathVariable(value = "id") Long clubedolivroId) {
	    ClubeDoLivro clubedolivro = clubedolivroRepository.findById(clubedolivroId)
	            .orElseThrow(() -> new ResourceNotFoundException("ClubeDoLivro", "id", clubedolivroId));

	    clubedolivroRepository.delete(clubedolivro);

	    return ResponseEntity.ok().build();
	}
}
