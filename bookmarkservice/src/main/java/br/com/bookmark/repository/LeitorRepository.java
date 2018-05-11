package br.com.bookmark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bookmark.model.Leitor;

@Repository
public interface LeitorRepository extends JpaRepository<Leitor, Long>{

}
