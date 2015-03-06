package br.com.cf.controller;

import java.util.List;

import br.com.cf.dao.DuvidaDAO;
import br.com.cf.entity.Duvida;

public class DuvidaController {
	private Duvida duvida;
	private List<Duvida> listaDuvidas;

	public DuvidaController() {
		if (duvida == null) {
			duvida = new Duvida();
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

	public List<Duvida> pesquisar(String consulta){
		
		DuvidaDAO.getInstance().pesquisar(consulta);
		
		return DuvidaDAO.getInstance().pesquisar(consulta);
	}
}