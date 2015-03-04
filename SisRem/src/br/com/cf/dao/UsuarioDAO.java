package br.com.cf.dao;

import java.security.NoSuchAlgorithmException;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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

	public Usuario autentica(Usuario usuario) throws NoSuchAlgorithmException {
		HibernateUtility.beginTransaction();
		HibernateUtility.getSession().flush();
		Criteria c = HibernateUtility.getSession()
				.createCriteria(Usuario.class);
		//c.add(Restrictions.eq("email", usuario.getEmail().toLowerCase()));
		c.add(Restrictions.eq("senha", usuario.getSenha()));
		HibernateUtility.commitTransaction();
		return (Usuario) c.uniqueResult();
	}

}
