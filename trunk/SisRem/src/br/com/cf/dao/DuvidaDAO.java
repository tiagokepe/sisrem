package br.com.cf.dao;

public class DuvidaDAO extends DAO {

	private static DuvidaDAO instance;
	
	public static DuvidaDAO getInstance() {
		if (instance == null) {
			instance = new DuvidaDAO();
		}
		return instance;
	}

}
