package br.com.cf.entity;

import java.io.Serializable;

public class Duvida implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long codigo;
	private String pergunta;
	private String resposta;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}