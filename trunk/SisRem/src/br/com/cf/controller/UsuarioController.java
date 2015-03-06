package br.com.cf.controller;


import br.com.cf.entity.Usuario;

public class UsuarioController {
	
	private Usuario usuario;

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

}