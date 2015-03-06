package br.com.cf.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.cf.dao.DuvidaDAO;
import br.com.cf.entity.Duvida;

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
	
	public void cadastrar(){
		try {
			DuvidaDAO.getInstance().save(duvida);
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Cadastro realizado com sucesso!"));
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage("", new FacesMessage(ERRO_OPERACAO));
		}
	}
}