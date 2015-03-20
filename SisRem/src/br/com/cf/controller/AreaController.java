package br.com.cf.controller;


import java.util.ArrayList;
import java.util.List;
import br.com.cf.entity.Area;
import br.com.cf.dao.AreaDAO;



public class AreaController {
	private List<Area> listaAreas = new ArrayList<Area>();
	private Area nome;
	
	public List<Area> getListaAreas() {
		return listaAreas;
	}

	public void setListaAreas(List<Area> listaAreas) {
		this.listaAreas = listaAreas;
	}
	

	public AreaController() {
		listaAreas = AreaDAO.getInstance().listByArea(nome);
	}

	

}