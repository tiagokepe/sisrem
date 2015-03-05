package br.com.cf.controller;

import java.io.IOException;
import java.text.ParseException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.cf.dao.UsuarioDAO;
import br.com.cf.entity.Usuario;

public class UsuarioController {
	
	private Usuario usuario;
	private Usuario usuarioAutenticado;

	public UsuarioController() {
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

	public Usuario getUsuarioAutenticada() {
		return usuarioAutenticado;
	}

	public void setUsuarioAutenticada(Usuario usuarioAutenticado) {
		this.usuarioAutenticado = usuarioAutenticado;
	}

	public void login() throws Exception {
		usuarioAutenticado = new Usuario();
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
		usuarioAutenticado = UsuarioDAO.getInstance().autentica(usuario);

		if (usuarioAutenticado != null) {
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
}