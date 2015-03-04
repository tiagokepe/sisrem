package br.com.cf.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cf.util.Encripty;
import br.com.cf.entity.Usuario;

public class UsuarioDAO extends DAO {

	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}

	public Usuario autentica(Usuario usuario) throws NoSuchAlgorithmException,
			SQLException {

		Usuario u = null;
		String sql = "SELECT u.login, u.senha, p.nome FROM comum.usuario u INNER JOIN comum.pessoa p ON u.id_pessoa = p.id_pessoa where u.login = '"
				+ usuario.getLogin().toLowerCase()
				+ "' "
				+ " and u.senha ='"
				+ Encripty.criptografaSenha(usuario.getSenha()) + "';";
		Statement stm = (Statement) JDBC.getConnection().createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			u = new Usuario();
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			u.setNome(rs.getString("nome"));
		}
		return u;
	}
}