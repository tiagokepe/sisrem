package br.com.cf.dao;

import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.cf.entity.Usuario;
import br.com.cf.util.Encripty;

public class SisRemDAO extends DAO {

	private static SisRemDAO instance;

	public static SisRemDAO getInstance() {
		if (instance == null) {
			instance = new SisRemDAO();
		}
		return instance;
	}

	public Usuario autentica(Usuario usuario) throws NoSuchAlgorithmException,
			SQLException {

		Usuario u = null;
		String sql = "SELECT u.login, u.senha, p.nome, p.id_pessoa, p.cpf_cnpj FROM "
				+ "comum.usuario u "
				+ "INNER JOIN comum.pessoa p ON u.id_pessoa = p.id_pessoa "
				+ "WHERE u.login = ? AND u.senha = ?";

		PreparedStatement pstm = JDBCComum.getConnection().prepareStatement(sql);

		pstm.setString(1, usuario.getLogin().toLowerCase());
		pstm.setString(2, Encripty.criptografaSenha(usuario.getSenha()));
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			u = new Usuario();
			u.setLogin(rs.getString("login"));
			u.setSenha(rs.getString("senha"));
			u.setNome(rs.getString("nome"));
			u.setIdPessoa(rs.getLong("id_pessoa"));
			u.setCpf(rs.getLong("cpf_cnpj"));
		}
		return u;
	}

}
