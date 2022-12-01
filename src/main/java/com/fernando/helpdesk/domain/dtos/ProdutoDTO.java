package com.fernando.helpdesk.domain.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fernando.helpdesk.domain.Produto;
import com.fernando.helpdesk.domain.enums.Categoria;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String foto;

	private Categoria categoria;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(Produto obj) {
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

}
