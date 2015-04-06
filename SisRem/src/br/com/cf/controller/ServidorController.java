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
import br.com.cf.util.EnviarEmail;

public class ServidorController {

	private Servidor servidor;
	private List<Intencao> intencaoList = new ArrayList<Intencao>();
	List<SelectItem> unidadeList;
	private Intencao intencao;

	public List<Intencao> getIntencaoList() {
		return intencaoList;
	}

	public void setIntencaoList(List<Intencao> intencaoList) {
		this.intencaoList = intencaoList;
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

	public Intencao getIntencao() {
		return intencao;
	}

	public void setIntencao(Intencao intencao) {
		this.intencao = intencao;
	}

	public void deferir() {
		FacesContext context = FacesContext.getCurrentInstance();
		intencao = (Intencao) context.getExternalContext().getRequestMap()
				.get("list");
		intencao.setStatus("DEFERIDO");
		DAO.getInstance().update(intencao);
		EnviarEmail e = new EnviarEmail();
		e.enviarEmailDeferido(intencao);
	}

	public void indeferir() {
		FacesContext context = FacesContext.getCurrentInstance();
		intencao = (Intencao) context.getExternalContext().getRequestMap()
				.get("list");
		intencao.setStatus("INDEFERIDO");
		DAO.getInstance().update(intencao);
		EnviarEmail e = new EnviarEmail();
		e.enviarEmailIndeferido(intencao);
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
		intencaoList = IntencaoDAO.getInstance().buscarIntencao(
				servidor.getSiape());
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
			intencao.setFase(Constantes.FASE_VIGENTE);
			intencao.setStatus("ABERTO");
			intencaoList.add(intencao);
			DAO.getInstance().save(intencao);
			intencao = new Intencao();
		} else {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Você pode optar no maximo por "
							+ Constantes.QTDE_MAXIMA_DE_DESTINOS
							+ " opções de destino!",
					"Você pode optar no maximo por "
							+ Constantes.QTDE_MAXIMA_DE_DESTINOS
							+ " opções de destino!");
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

	public void listarIntencoes() throws IOException {
		intencaoList = new ArrayList<Intencao>();
		intencaoList = IntencaoDAO.getInstance().listarIntencaoAprovacao();
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("aprovarIntencao.jsp");
	}
	
	public void listarIntencoesSolicitante() throws IOException, ParseException, SQLException {
		intencaoList = new ArrayList<Intencao>();
		buscarUsuarioLogado();
		List<Intencao> intencaoAux = new ArrayList<Intencao>();
		intencaoAux = IntencaoDAO.getInstance().buscarIntencao(
				servidor.getSiape());
		for(Intencao i : intencaoAux){
			intencaoList.addAll(IntencaoDAO.getInstance().listarIntencaoSolicitante(i));
			FacesContext.getCurrentInstance().getExternalContext()
				.redirect("acompanharIntencao.jsp");
		}
	}

}
