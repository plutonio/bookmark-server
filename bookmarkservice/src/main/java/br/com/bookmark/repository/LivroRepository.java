package br.com.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookmark.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{

}

