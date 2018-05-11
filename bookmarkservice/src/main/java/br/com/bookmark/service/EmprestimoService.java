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
import br.com.bookmark.model.Emprestimo;
import br.com.bookmark.repository.EmprestimoRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmprestimoService {
	
	@Autowired
	private EmprestimoRepository emprestimoRepository;

	// Buscar Todos Emprestimos
	@GetMapping("/emprestimos")
	public List<Emprestimo> getAllEmprestimoes() {
	    return emprestimoRepository.findAll();
	}
	
	// Criar um Novo Emprestimo
	@PostMapping("/emprestimo")
	public Emprestimo createEmprestimo(@Valid @RequestBody Emprestimo emprestimo) {
	    return emprestimoRepository.save(emprestimo);
	}
	
	// Buscar Emprestimo por Código  
	@GetMapping("/emprestimo/{id}")
	public Emprestimo getEmprestimoById(@PathVariable(value = "id") Long emprestimoId) {
	    return emprestimoRepository.findById(emprestimoId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Emprestimo", "id", emprestimoId));
	         
	}
	
	// Editar um Emprestimo
	@PutMapping("/emprestimo/{id}")
	public Emprestimo updateEmprestimo(@PathVariable(value = "id") Long emprestimoId,
	                                        @Valid @RequestBody Emprestimo emprestimoDetails) {

	    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo", "id", emprestimoId));
	    
	    emprestimo.setDataEmprestimo(emprestimoDetails.getDataEmprestimo());
	    emprestimo.setDataDevolucao(emprestimoDetails.getDataDevolucao());
	    emprestimo.setLivro(emprestimoDetails.getLivro());
	    emprestimo.setPessoa(emprestimoDetails.getPessoa());
	    emprestimo.setStatus(emprestimoDetails.getStatus());

	    Emprestimo updatedEmprestimo = emprestimoRepository.save(emprestimo);
	    return updatedEmprestimo;
	}
	
	// Deletar um Emprestimo
	@DeleteMapping("/emprestimo/{id}")
	public ResponseEntity<?> deleteEmprestimo(@PathVariable(value = "id") Long emprestimoId) {
	    Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
	            .orElseThrow(() -> new ResourceNotFoundException("Emprestimo", "id", emprestimoId));

	    emprestimoRepository.delete(emprestimo);

	    return ResponseEntity.ok().build();
	}

}
