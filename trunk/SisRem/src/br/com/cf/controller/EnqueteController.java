package br.com.cf.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cf.dao.DAO;
import br.com.cf.dao.EnqueteDAO;
import br.com.cf.entity.Enquete;
import br.com.cf.entity.Usuario;

public class EnqueteController {
	private Enquete enquete;
	private boolean habilitaPergunta1 = true;
	private boolean habilitaPergunta3 = true;
	private boolean habilitaPergunta7 = true;
	private boolean habilitaPergunta9 = true;
	private boolean habilitaPergunta10 = true;
	private boolean habilitaPergunta13 = true;

	private List<Enquete> enqueteList = new ArrayList<Enquete>();

	public Enquete getEnquete() {
		return enquete;
	}

	public void setEnquete(Enquete enquete) {
		this.enquete = enquete;
	}

	public List<Enquete> getEnqueteList() {
		return enqueteList;
	}

	public void setEnqueteList(List<Enquete> enqueteList) {
		this.enqueteList = enqueteList;
	}

	public boolean isHabilitaPergunta1() {
		return habilitaPergunta1;
	}

	public void setHabilitaPergunta1(boolean habilitaPergunta1) {
		this.habilitaPergunta1 = habilitaPergunta1;
	}

	public boolean isHabilitaPergunta3() {
		return habilitaPergunta3;
	}

	public void setHabilitaPergunta3(boolean habilitaPergunta3) {
		this.habilitaPergunta3 = habilitaPergunta3;
	}

	public boolean isHabilitaPergunta7() {
		return habilitaPergunta7;
	}

	public void setHabilitaPergunta7(boolean habilitaPergunta7) {
		this.habilitaPergunta7 = habilitaPergunta7;
	}

	public boolean isHabilitaPergunta9() {
		return habilitaPergunta9;
	}

	public void setHabilitaPergunta9(boolean habilitaPergunta9) {
		this.habilitaPergunta9 = habilitaPergunta9;
	}

	public boolean isHabilitaPergunta10() {
		return habilitaPergunta10;
	}

	public void setHabilitaPergunta10(boolean habilitaPergunta10) {
		this.habilitaPergunta10 = habilitaPergunta10;
	}

	public boolean isHabilitaPergunta13() {
		return habilitaPergunta13;
	}

	public void setHabilitaPergunta13(boolean habilitaPergunta13) {
		this.habilitaPergunta13 = habilitaPergunta13;
	}

	public void habilitaCampus() {
		if (("Outro").equals(enquete.getPergunta1())) {
			habilitaPergunta1 = true;
		} else {
			habilitaPergunta1 = false;
		}
		if (("Outro").equals(enquete.getPergunta3())) {
			habilitaPergunta3 = true;
		} else {
			habilitaPergunta3 = false;
		}
		if (("Outro").equals(enquete.getPergunta7())) {
			habilitaPergunta7 = true;
		} else {
			habilitaPergunta7 = false;
		}
		if (("Outro").equals(enquete.getPergunta9())) {
			habilitaPergunta9 = true;
		} else {
			habilitaPergunta9 = false;
		}
		if (("Outro").equals(enquete.getPergunta10())) {
			habilitaPergunta10 = true;
		} else {
			habilitaPergunta10 = false;
		}
		if (("Outro").equals(enquete.getPergunta13J())) {
			habilitaPergunta13 = true;
		} else {
			habilitaPergunta13 = false;
		}
	}

	public void salvar() throws IOException {
		try {
			boolean validado = true;
			FacesMessage message = null;
			if (enquete.getPergunta1().equals("Outro")
					&& enquete.getPergunta1Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 1 você deve especificar!",
						"Ao selecionar Outro na Pergunta 1 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta3().equals("Outro")
					&& enquete.getPergunta3Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 3 você deve especificar!",
						"Ao selecionar Outro na Pergunta 3 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta7().equals("Outro")
					&& enquete.getPergunta7Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 7 você deve especificar!",
						"Ao selecionar Outro na Pergunta 7 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta9().equals("Outro")
					&& enquete.getPergunta9Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 9 você deve especificar!",
						"Ao selecionar Outro na Pergunta 9 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta10().equals("Outro")
					&& enquete.getPergunta10Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 10 você deve especificar!",
						"Ao selecionar Outro na Pergunta 10 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta13J().equals("true")
					&& enquete.getPergunta13Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 13 você deve especificar!",
						"Ao selecionar Outro na Pergunta 13 você deve especificar!");
				validado = false;
			}
			if (enquete.getPergunta23J().equals("true")
					&& enquete.getPergunta23Text().isEmpty()) {
				message = new FacesMessage(
						FacesMessage.SEVERITY_ERROR,
						"Ao selecionar Outro na Pergunta 23 você deve especificar!",
						"Ao selecionar Outro na Pergunta 23 você deve especificar!");
				validado = false;
			}
			if (validado) {
				DAO.getInstance().save(enquete);
				@SuppressWarnings("unused")
				HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
						.getExternalContext().getSession(false);
			} else {
				FacesContext.getCurrentInstance().addMessage("", message);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void cadastrarNovo() throws IOException, ParseException {
		buscarUsuarioLogado();
		Enquete enq = EnqueteDAO.getInstance()
				.jaRespondeu(enquete.getUsuario());
		if (enq == null) {
			habilitaPergunta1 = false;
			habilitaPergunta3 = false;
			habilitaPergunta7 = false;
			habilitaPergunta9 = false;
			habilitaPergunta10 = false;
			habilitaPergunta13 = false;
			try {
				FacesContext.getCurrentInstance().getExternalContext()
						.redirect("cadastrar.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("erro.jsp");
		}

	}

	public void carregar() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		enquete = (Enquete) context.getExternalContext().getRequestMap()
				.get("list");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("cadastrar.jsp");
	}

	public boolean buscarUsuarioLogado() throws IOException, ParseException {
		enquete = new Enquete();
		enquete.setUsuario(new Usuario());
		Usuario usuarioLogado = (Usuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("Logado");
		if (usuarioLogado != null) {
			enquete.setUsuario(usuarioLogado);
			return true;
		} else {
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	public void listarEnquetes() throws ParseException {
		try {
			enquete = new Enquete();
			enqueteList = (List<Enquete>) DAO.getInstance().list(Enquete.class,
					"codigo");
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("listar.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
