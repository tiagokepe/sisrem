package br.com.cf.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cf.dao.SisRemDAO;
import br.com.cf.dao.UsuarioDAO;
import br.com.cf.entity.Usuario;

public class SisRemController {
	
	Usuario usuario;
	
	public SisRemController() {
		if (usuario == null) {
			usuario = new Usuario();
		}
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void login() throws Exception {
		Usuario usuarioAutenticado = new Usuario();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuarioAutenticado = SisRemDAO.getInstance().autentica(usuario);

		if (usuarioAutenticado != null) {
			UsuarioDAO.getInstance().verificaAdmin(usuarioAutenticado);
			session.setAttribute("usuarioLogado", usuarioAutenticado);
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("inicio.jsp");
			usuario = new Usuario();
			session.setMaxInactiveInterval(-1);
		} else {
			session.setAttribute("usuarioLogado", null);
			session.removeAttribute("user");
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Senha inválida!",
					"Senha inválida!");
			FacesContext.getCurrentInstance().addMessage("", message);
		}
	}
	
	public void buscarServidorLogado() throws IOException, ParseException {
		usuario = (Usuario) FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap().get("usuarioLogado");
	}

	public void logout () throws IOException{
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		session.invalidate();
		FacesContext.getCurrentInstance().getExternalContext().redirect("login.jsp");
	}

}
