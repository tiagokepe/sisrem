package br.com.cf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.cf.entity.Duvida;
import br.com.cf.util.HibernateUtility;

public class DuvidaDAO extends DAO {

	private static DuvidaDAO instance;

	public static DuvidaDAO getInstance() {
		if (instance == null) {
			instance = new DuvidaDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Duvida> pesquisar(String consulta) {
		
		HibernateUtility.getSession().clear();
		Criteria criteria = HibernateUtility.getSession().createCriteria(Duvida.class)
				.add(Restrictions.or(
						Restrictions.like("enunciado", consulta), 
						Restrictions.like("descricao", consulta))
					);
		HibernateUtility.commitTransaction();
		return (List<Duvida>) criteria.list();
	}
}