package br.com.cf.entity;

import java.io.Serializable;
import java.util.Date;

public class Intencao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private Long siape;
	private String edital;
	private String destino;
	private Date dataInscricao;
	private String area;
	private String justificativa;
	
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	
	public Long getSiape() {
		return siape;
	}
	public void setSiape(Long siape) {
		this.siape = siape;
	}
	public String getEdital() {
		return edital;
	}
	public void setEdital(String edital) {
		this.edital = edital;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getDataInscricao() {
		return dataInscricao;
	}
	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
}
