package br.com.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookmark.model.ClubeDoLivro;

@Repository
public interface ClubeDoLivroRepository extends JpaRepository<ClubeDoLivro, Long>{

}
