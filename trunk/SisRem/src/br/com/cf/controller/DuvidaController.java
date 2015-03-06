package br.com.cf.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.cf.dao.DuvidaDAO;
import br.com.cf.entity.Duvida;

public class DuvidaController {
	private Duvida duvida;
	private List<Duvida> listaDuvidas = new ArrayList<Duvida>();

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
}