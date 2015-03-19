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
		String sql = "SELECT id_area_conhecimento_cnpq, nome FROM funcional.area_conhecimento_cnpq WHERE id_sub_area IS NULL and excluido = 'f' ORDER BY nome ASC";
		Statement stm = (Statement) JDBCAdministrativo.getConnection().createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while (rs.next()) {
			Area u = new Area();
			u.setCodigo(rs.getLong("id_area_conhecimento_cnpq"));
			u.setNome(rs.getString("nome"));
			areaList.add(u);
		}
		return areaList;
	}

}