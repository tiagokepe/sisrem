package br.com.cf.dao;

public class UsuarioDAO extends DAO {

	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

}