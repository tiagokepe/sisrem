package br.com.cf.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cf.entity.Unidade;

public class UnidadeDAO extends DAO {

	private static UnidadeDAO instance;

	public static UnidadeDAO getInstance() {
		if (instance == null) {
			instance = new UnidadeDAO();
		}
		return instance;
	}

	public List<Unidade> buscaUnidades() throws SQLException {
		List<Unidade> unidadeList = new ArrayList<Unidade>();
		String sql = "SELECT U.ID_UNIDADE, U.NOME FROM COMUM.UNIDADE U ORDER BY U.NOME";
		Statement stm = (Statement) JDBC.getConnection().createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Unidade u = new Unidade();
			u.setCodigo(rs.getLong("id_unidade"));
			u.setNome(rs.getString("nome"));
			unidadeList.add(u);
		}
		return unidadeList;
	}

}