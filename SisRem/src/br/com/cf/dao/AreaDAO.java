package br.com.cf.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.cf.entity.Area;
import br.com.cf.util.HibernateUtility;

public class AreaDAO extends DAO {

	private static AreaDAO instance;

	public static AreaDAO getInstance() {
		if (instance == null) {
			instance = new AreaDAO();
		}
		return instance;
	}

	@SuppressWarnings("unchecked")
	public List<Area> listByArea(Area area) {
		HibernateUtility.getSession().clear();
		HibernateUtility.beginTransaction();
		HibernateUtility.commitTransaction();
		return HibernateUtility.getSession().createCriteria(Area.class).add(
				Restrictions.eq("nome", area)).addOrder(Order.asc("nome")).list();
	}
	
	/*public List<Area> pesquisar(String consulta) {
		
		HibernateUtility.getSession().clear();
		Criteria criteria = HibernateUtility.getSession().createCriteria(Area.class).add(Restrictions.eq("nome", consulta));

		HibernateUtility.commitTransaction();
		return (List<Area>) criteria.list();
	}*/
}