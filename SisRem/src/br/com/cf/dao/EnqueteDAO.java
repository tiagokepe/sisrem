package br.com.cf.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.cf.entity.Enquete;
import br.com.cf.entity.Usuario;
import br.com.cf.util.HibernateUtility;

public class EnqueteDAO extends DAO {

	private static EnqueteDAO instance;

	public static EnqueteDAO getInstance() {
		if (instance == null) {
			instance = new EnqueteDAO();
		}
		return instance;
	}

	public Enquete jaRespondeu(Usuario usuario)  {
		HibernateUtility.beginTransaction();
		Criteria c = HibernateUtility.getSession()
				.createCriteria(Enquete.class);
		c.add(Restrictions.eq("usuario", usuario));
		HibernateUtility.commitTransaction();
		return (Enquete) c.uniqueResult();
	}

}
