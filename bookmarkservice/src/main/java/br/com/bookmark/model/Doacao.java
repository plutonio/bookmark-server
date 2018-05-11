package br.com.bookmark.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name="doacao")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Doacao implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="status")
	private String status;
	
	@Column(name="livro")
	private Livro livro;
	
	@Column(name="doador")
	private Leitor doador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Leitor getDoador() {
		return doador;
	}

	public void setDoador(Leitor doador) {
		this.doador = doador;
	}
	

}
