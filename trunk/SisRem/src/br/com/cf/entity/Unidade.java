package br.com.cf.entity;

import java.io.Serializable;

public class Unidade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private Long codigo;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
