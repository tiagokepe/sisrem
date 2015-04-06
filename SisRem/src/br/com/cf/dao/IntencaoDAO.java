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
	public List<Intencao> buscarIntencao(Long siape) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility.getSession().createQuery(
				"from Intencao i where i.siape = :siape");
		query.setParameter("siape", siape);
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Intencao> buscarIntencaoPrimeiraFase() {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Intencao i where i.fase = 1 order by i.destino, i.cargo, i.admissao, i.nascimento, i.dataInscricao");
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Intencao> buscarIntencaoSegundaFase() {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Intencao i where i.fase = 2 order by i.destino, i.cargo, i.dataInscricao");
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Intencao> listarIntencaoAprovacao() {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Intencao i order by i.fase, i.colocacao, i.destino, i.cargo, i.admissao, i.nascimento, i.dataInscricao");
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}

	@SuppressWarnings("unchecked")
	public List<Intencao> listarIntencaoSolicitante(Intencao intencao) {
		HibernateUtility.getSession().clear();
		Query query = HibernateUtility
				.getSession()
				.createQuery(
						"from Intencao i "
								+ " where i.destino = :destino and i.cargo = :cargo order by i.fase, i.colocacao, i.destino, i.cargo, i.admissao, i.nascimento, i.dataInscricao");
		query.setParameter("destino", intencao.getDestino());
		query.setParameter("cargo", intencao.getCargo());
		HibernateUtility.commitTransaction();
		return (List<Intencao>) query.list();
	}
}