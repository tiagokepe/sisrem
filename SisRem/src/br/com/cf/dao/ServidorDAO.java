package br.com.cf.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.cf.entity.Servidor;

public class ServidorDAO extends DAO {

	private static ServidorDAO instance;

	public static ServidorDAO getInstance() {
		if (instance == null) {
			instance = new ServidorDAO();
		}
		return instance;
	}

	public Servidor buscaServidor(Long idPessoa) throws SQLException {
		Servidor s = null;
		String sql = "SELECT P.NOME, P.DATA_NASCIMENTO, P.TELEFONE, P.CELULAR, P.EMAIL, S.SIAPE, S.ADMISSAO, C.DENOMINACAO, CT.DESCRICAO, U.NOME as unidade FROM COMUM.PESSOA P"
				+ " INNER JOIN RH.SERVIDOR S ON P.ID_PESSOA = S.ID_PESSOA"
				+ " INNER JOIN RH.CARGO C ON S.ID_CARGO = C.ID"
				+ " INNER JOIN RH.CATEGORIA CT ON S.ID_CATEGORIA = CT.ID_CATEGORIA"
				+ " INNER JOIN COMUM.UNIDADE U ON S.ID_UNIDADE = U.ID_UNIDADE"
				+ " WHERE P.ID_PESSOA = " + idPessoa;
		Statement stm = (Statement) JDBC.getConnection().createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			s = new Servidor();
			s.setNome(rs.getString("nome"));
			s.setEmail(rs.getString("email"));
			s.setUnidade(rs.getString("unidade"));
			s.setSiape(rs.getLong("siape"));
			s.setCargo(rs.getString("denominacao"));
			s.setCategoria(rs.getString("descricao"));
			s.setDataAdmissao(rs.getDate("admissao"));
			s.setDataNascimento(rs.getDate("data_nascimento"));
			s.setCelular(rs.getString("celular"));
			s.setTelefone(rs.getString("telefone"));
		}
		return s;
	}

}