package com.fernando.helpdesk.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernando.helpdesk.domain.dtos.ProdutoDTO;
import com.fernando.helpdesk.domain.enums.Categoria;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String foto;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;


	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();

	public Produto() {
		super();
	}

	public Produto(Integer id, String nome, String foto, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.foto = foto;
		this.categoria = categoria;
	}

	public Produto(ProdutoDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.foto = obj.getFoto();
		this.categoria = obj.getCategoria();
		this.dataCriacao = obj.getDataCriacao();
	}

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Produto produto = (Produto) obj;
		return id.equals(produto.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
