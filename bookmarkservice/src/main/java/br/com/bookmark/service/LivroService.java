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
import br.com.bookmark.model.Livro;
import br.com.bookmark.repository.LeitorRepository;
import br.com.bookmark.repository.LivroRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;

	// Buscar Todos Leitores
	@GetMapping("/livros")
	public List<Livro> getAllLivros() {
	    return livroRepository.findAll();
	}
	
	// Criar um Novo Leitor
	@PostMapping("/livro")
	public Livro createLivro(@Valid @RequestBody Livro livro) {
	    return livroRepository.save(livro);
	}
	
	// Buscar Leitor por Código  
	@GetMapping("/livro/{id}")
	public Livro getLivroById(@PathVariable(value = "id") Long livroId) {
	    return livroRepository.findById(livroId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Livro", "id", livroId));
	         
	}
	
	// Editar um Leitor
	@PutMapping("/livro/{id}")
	public Livro updateLivro(@PathVariable(value = "id") Long livroId,
	                                        @Valid @RequestBody Livro livroDetails) {

	    Livro livro = livroRepository.findById(livroId)
	            .orElseThrow(() -> new ResourceNotFoundException("Livro", "id", livroId));
	    
	    livro.setTitulo(livroDetails.getTitulo());
	    livro.setAutor(livroDetails.getAutor());
	    livro.setEditora(livroDetails.getEditora());
	    livro.setDataFimLeitura(livroDetails.getDataFimLeitura());
	    livro.setDataInicioLeitura(livroDetails.getDataInicioLeitura());
	    livro.setResumo(livroDetails.getResumo());
	    livro.setIsbn(livroDetails.getIsbn());
	    livro.setQtdPaginas(livroDetails.getQtdPaginas());
	    livro.setImagem(livroDetails.getImagem());

	    Livro updatedLivro = livroRepository.save(livro);
	    return updatedLivro;
	}
	
	// Deletar um Leitor
	@DeleteMapping("/livro/{id}")
	public ResponseEntity<?> deleteLivro(@PathVariable(value = "id") Long livroId) {
	    Livro livro = livroRepository.findById(livroId)
	            .orElseThrow(() -> new ResourceNotFoundException("Livro", "id", livroId));

	    livroRepository.delete(livro);

	    return ResponseEntity.ok().build();
	}


}
