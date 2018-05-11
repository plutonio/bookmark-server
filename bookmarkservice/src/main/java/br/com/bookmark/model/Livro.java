package br.com.bookmark.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Table(name="livro")
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Livro implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)  
	@Column(name="id")
	private Long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="autor")
	private String autor;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="data_inicio_leitura")
	private Date dataInicioLeitura;
	
	@Column(name="data_fim_leitura")
	private Date dataFimLeitura;
	
	@Column(name="resumo")
	private String resumo;
	
	private String isbn;
	
	private String editora;
	
	private String dataPublicacao;
	
	private int qtdePaginas;
	
	private byte[] imagem;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getDataInicioLeitura() {
		return dataInicioLeitura;
	}

	public void setDataInicioLeitura(Date dataInicioLeitura) {
		this.dataInicioLeitura = dataInicioLeitura;
	}

	public Date getDataFimLeitura() {
		return dataFimLeitura;
	}

	public void setDataFimLeitura(Date dataFimLeitura) {
		this.dataFimLeitura = dataFimLeitura;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public int getQtdePaginas() {
		return qtdePaginas;
	}

	public void setQtdePaginas(int qtdePaginas) {
		this.qtdePaginas = qtdePaginas;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}
