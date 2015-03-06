package br.com.cf.dao;

import org.hibernate.Query;

import br.com.cf.entity.Usuario;
import br.com.cf.util.HibernateUtility;

public class UsuarioDAO extends DAO {

	private static UsuarioDAO instance;

	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}
		return instance;
	}
	
	public void verificaAdmin(Usuario u){
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery("from Usuario u where u.login = :login");
		query.setParameter("login", u.getLogin());
		HibernateUtility.commitTransaction();
		
		Usuario usuario = (Usuario) query.uniqueResult();
		
		if(usuario != null){
			u.setAdmin(true);
		}else{
			u.setAdmin(false);
		}
	}

}