package br.com.cf.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.poi.hssf.util.HSSFColor.TURQUOISE;

import br.com.cf.dao.DAO;
import br.com.cf.dao.DuvidaDAO;
import br.com.cf.entity.Duvida;
import br.com.cf.entity.Intencao;

public class DuvidaController {
	private Duvida duvida;
	private List<Duvida> listaDuvidas = new ArrayList<Duvida>();
	private static final String ERRO_OPERACAO = "Ocorreu um erro durante a operação";

	@SuppressWarnings("unchecked")
	public DuvidaController() {
		if (duvida == null) {
			duvida = new Duvida();
		}
		if(listaDuvidas.size() == 0){
			listaDuvidas = DuvidaDAO.getInstance().list(Duvida.class);
		}
	}

	public List<Duvida> getListaDuvidas() {
		return listaDuvidas;
	}

	public void setListaDuvidas(List<Duvida> listaDuvidas) {
		this.listaDuvidas = listaDuvidas;
	}

	public Duvida getDuvida() {
		return duvida;
	}

	public void setDuvida(Duvida duvida) {
		this.duvida = duvida;
	}

	public void pesquisar(String consulta){
		listaDuvidas = DuvidaDAO.getInstance().pesquisar(consulta);
	}
		
	@SuppressWarnings("unchecked")
	public void salvar() throws IOException{
		try {
			if (duvida.getCodigo() == 0){
				duvida.setCodigo(null);
			}
			
			DuvidaDAO.getInstance().saveOrUpdate(duvida);
			listaDuvidas = (List<Duvida>) DuvidaDAO.getInstance().list(Duvida.class);
			duvida = new Duvida();
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Dúvida gravada com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(ERRO_OPERACAO));
		} finally {
			FacesContext.getCurrentInstance().getExternalContext().redirect("listar_duvidas.jsp");
		}
	}
	
	public void nova() throws IOException{
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("form_duvida.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar() throws IOException{
		duvida = new Duvida();
		FacesContext.getCurrentInstance().getExternalContext().redirect("listar_duvidas.jsp");
	}
	
	public void editar() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		duvida = (Duvida) context.getExternalContext().getRequestMap()
				.get("duvida");
		context.getExternalContext().redirect("form_duvida.jsp");
	}
	
	@SuppressWarnings("unchecked")
	public void excluir() throws IOException{
		FacesContext context = FacesContext.getCurrentInstance();
		duvida = (Duvida) context.getExternalContext().getRequestMap()
				.get("duvida");
		DuvidaDAO.getInstance().delete(duvida);
		listaDuvidas = (List<Duvida>) DuvidaDAO.getInstance().list(Duvida.class);
		duvida = new Duvida();
	}
	
	public void cancelar() throws IOException{
		duvida = new Duvida();
		FacesContext.getCurrentInstance().getExternalContext().redirect("form_duvida.jsp");
	}
}