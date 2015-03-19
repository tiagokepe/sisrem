package br.com.cf.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cf.entity.Area;

public class AreaDAO extends DAO {

	private static AreaDAO instance;

	public static AreaDAO getInstance() {
		if (instance == null) {
			instance = new AreaDAO();
		}
		return instance;
	}

	public List<Area> buscaAreas() throws SQLException {
		List<Area> areaList = new ArrayList<Area>();
		String sql = "SELECT DISTINCT U.ID_UNIDADE, U.NOME FROM COMUM.UNIDADE U INNER JOIN RH.SERVIDOR S ON S.ID_UNIDADE = U.ID_UNIDADE WHERE S.DATA_DESLIGAMENTO IS NULL ORDER BY U.NOME";
		Statement stm = (Statement) JDBCAdministrativo.getConnection().createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Area u = new Area();
			u.setCodigo(rs.getLong("id_unidade"));
			u.setNome(rs.getString("nome"));
			areaList.add(u);
		}
		return areaList;
	}

}