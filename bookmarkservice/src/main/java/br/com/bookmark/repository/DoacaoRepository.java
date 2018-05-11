package br.com.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookmark.model.Doacao;

@Repository
public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

}
