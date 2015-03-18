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
		String sql = "SELECT DISTINCT U.ID_UNIDADE, U.NOME FROM COMUM.UNIDADE U INNER JOIN RH.SERVIDOR S ON S.ID_UNIDADE = U.ID_UNIDADE WHERE S.DATA_DESLIGAMENTO IS NULL ORDER BY U.NOME";
		Statement stm = (Statement) JDBCAdministrativo.getConnection().createStatement();
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