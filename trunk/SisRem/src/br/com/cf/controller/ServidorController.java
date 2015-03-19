package br.com.cf.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.com.cf.dao.AreaDAO;
import br.com.cf.dao.DAO;
import br.com.cf.dao.ServidorDAO;
import br.com.cf.dao.UnidadeDAO;
import br.com.cf.entity.Area;
import br.com.cf.entity.Servidor;
import br.com.cf.entity.Unidade;
import br.com.cf.entity.Usuario;

public class ServidorController {

	private Servidor servidor;
	private List<Servidor> servidorList = new ArrayList<Servidor>();
	List<SelectItem> unidadeList;
	List<SelectItem> areaList;
	
	public Servidor getServidor() {
		return servidor;
	}


	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}


	public List<Servidor> getServidorList() {
		return servidorList;
	}


	public void setServidorList(List<Servidor> servidorList) {
		this.servidorList = servidorList;
	}


	public List<SelectItem> getUnidadeList() {
		return unidadeList;
	}


	public void setUnidadeList(List<SelectItem> unidadeList) {
		this.unidadeList = unidadeList;
	}
	
	public List<SelectItem> getAreaList() {
		return areaList;
	}


	public void seAreaList(List<SelectItem> areaList) {
		this.areaList = areaList;
	}
	
	
	public void salvar() throws IOException {
				DAO.getInstance().save(servidor);
				@SuppressWarnings("unused")
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
						.getExternalContext().getSession(false);
	}


	public void cadastrar() throws IOException, ParseException, SQLException {
		buscarUsuarioLogado();
		buscarUnidades();
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("solicitar_remocao.jsp");
	}
 
	public List<SelectItem> buscarUnidades() throws SQLException{
		unidadeList = new ArrayList<SelectItem>();
		List<Unidade> ulist = new ArrayList<Unidade>();
		ulist = UnidadeDAO.getInstance().buscaUnidades();
		for (Unidade item : ulist) {
			unidadeList.add(new SelectItem(item.getNome(), item
					.getNome()));
		}
		return unidadeList;
	}
	
	public List<SelectItem> buscarAreas() throws SQLException{
		areaList = new ArrayList<SelectItem>();
		List<Area> uarea = new ArrayList<Area>();
		uarea = AreaDAO.getInstance().buscaAreas();
		for (Area item : uarea) {
			areaList.add(new SelectItem(item.getNome(), item. getNome()));
		}
		return areaList;
	}
	

	public void buscarUsuarioLogado() throws IOException, ParseException, SQLException {
		servidor = new Servidor();
		Usuario usuarioLogado = (Usuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("usuarioLogado");
		servidor = ServidorDAO.getInstance().buscaServidor(usuarioLogado.getIdPessoa());
	}

}
