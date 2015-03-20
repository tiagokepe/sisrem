package br.com.cf.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.cf.entity.Intencao;
import br.com.cf.util.HibernateUtility;

public class IntencaoDAO extends DAO {

	private static IntencaoDAO instance;

	public static IntencaoDAO getInstance() {
		if (instance == null) {
			instance = new IntencaoDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Intencao> buscarIntencao(Long siape){
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery("from Intencao i where i.siape = :siape");
		query.setParameter("siape", siape);
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}
}