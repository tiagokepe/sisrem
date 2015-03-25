package br.com.cf.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

import br.com.cf.constantes.Constantes;
import br.com.cf.dao.DAO;
import br.com.cf.dao.IntencaoDAO;
import br.com.cf.dao.ServidorDAO;
import br.com.cf.dao.UnidadeDAO;
import br.com.cf.entity.Intencao;
import br.com.cf.entity.Servidor;
import br.com.cf.entity.Unidade;
import br.com.cf.entity.Usuario;

public class ServidorController {

	private Servidor servidor;
	private List<Intencao> intencaoList = new ArrayList<Intencao>();
	List<SelectItem> unidadeList;
	List<SelectItem> areaList;
	private Intencao intencao;

	public List<Intencao> getIntencaoList() {
		return intencaoList;
	}

	public void setIntencaoList(List<Intencao> intencaoList) {
		this.intencaoList = intencaoList;
	}

	public void setAreaList(List<SelectItem> areaList) {
		this.areaList = areaList;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
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

	public Intencao getIntencao() {
		return intencao;
	}

	public void setIntencao(Intencao intencao) {
		this.intencao = intencao;
	}

	public void salvar() throws IOException {
		DAO.getInstance().save(servidor);
		@SuppressWarnings("unused")
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	public void cadastrar() throws IOException, ParseException, SQLException {
		intencao = new Intencao();
		intencaoList = new ArrayList<Intencao>();
		buscarUsuarioLogado();
		buscarUnidades();
		intencaoList = IntencaoDAO.getInstance().buscarIntencao(servidor.getSiape());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("solicitar_remocao.jsp");
	}

	public List<SelectItem> buscarUnidades() throws SQLException {
		unidadeList = new ArrayList<SelectItem>();
		List<Unidade> ulist = new ArrayList<Unidade>();
		ulist = UnidadeDAO.getInstance().buscaUnidades();
		for (Unidade item : ulist) {
			unidadeList.add(new SelectItem(item.getNome(), item.getNome()));
		}
		return unidadeList;
	}

	public void buscarUsuarioLogado() throws IOException, ParseException,
			SQLException {
		servidor = new Servidor();
		Usuario usuarioLogado = (Usuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("usuarioLogado");
		servidor = ServidorDAO.getInstance().buscaServidor(
				usuarioLogado.getCpf());
	}

	public void adicionarIntencao() {
		if (intencaoList.size() < Constantes.QTDE_MAXIMA_DE_DESTINOS) {
			intencao.setDataInscricao(new Date());
			intencao.setSiape(servidor.getSiape());
			intencao.setAdmissao(servidor.getDataAdmissao());
			intencao.setOrigem(servidor.getUnidade());
			intencao.setNascimento(servidor.getDataNascimento());
			intencao.setEmail(servidor.getEmail());
			intencao.setCargo(servidor.getCargo());
			intencao.setNome(servidor.getNome());
			//if(intencao.getDataInscricao().compareTo(Constantes.DATA_FINAL_PRIMEIRA_FASE)==1){
				intencao.setFase(1);
		//	}else{
		//		intencao.setFase(2);
		//	}
			
			intencaoList.add(intencao);
			DAO.getInstance().save(intencao);
			intencao = new Intencao();
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Voc� pode optar no maximo por "
							+ Constantes.QTDE_MAXIMA_DE_DESTINOS
							+ " op��es de destino!",
					"Voc� pode optar no maximo por "
							+ Constantes.QTDE_MAXIMA_DE_DESTINOS
							+ " op��es de destino!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}

	}
	
	
	public void excluirIntencao() throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		intencao = (Intencao) context.getExternalContext().getRequestMap()
				.get("list");
		intencaoList.remove(intencao);
		DAO.getInstance().delete(intencao);
		intencao = new Intencao();
	}

}
