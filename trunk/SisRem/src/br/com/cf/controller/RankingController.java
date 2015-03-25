package br.com.cf.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import br.com.cf.dao.DAO;
import br.com.cf.dao.IntencaoDAO;
import br.com.cf.entity.Intencao;

public class RankingController {

	List<Intencao> intencaoList;

	public void cadastrar() throws IOException, ParseException, SQLException {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("ranquear.jsp");
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarIntencaoPrimeiraFase() {
		intencaoList = new ArrayList();
		intencaoList = IntencaoDAO.getInstance().buscarIntencaoPrimeiraFase();
	}

	public void ranquearPrimeiraFase() {
		buscarIntencaoPrimeiraFase();
		int contador = 1;
		String destino = intencaoList.get(0).getDestino();
		String cargo = intencaoList.get(0).getCargo();
		for (Intencao item : intencaoList) {
			if (!(item.getDestino().equals(destino))) {
				if (item.getCargo().equals(cargo)) {
					destino = item.getDestino();
					contador = 1;
					item.setColocacao(contador);
					DAO.getInstance().update(item);
					contador++;
					// EnviarEmail e = new EnviarEmail();
					// e.enviarEmail(item.getEmail());}
				} else {
					cargo = item.getCargo();
					contador = 1;
					item.setColocacao(contador);
					DAO.getInstance().update(item);
					contador++;
				}
			} else {
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				contador++;
				// EnviarEmail e = new EnviarEmail();
				// e.enviarEmail(item.getEmail());
			}
		}

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void buscarIntencaoSegundaFase() {
		intencaoList = new ArrayList();
		intencaoList = IntencaoDAO.getInstance().buscarIntencaoSegundaFase();
	}

	public void ranquearSegundaFase() {
		buscarIntencaoSegundaFase();
		int contador = 1;
		String destino = intencaoList.get(0).getDestino();
		String cargo = intencaoList.get(0).getCargo();
		for (Intencao item : intencaoList) {
			if (!(item.getDestino().equals(destino))) {
				if (item.getCargo().equals(cargo)) {
					destino = item.getDestino();
					contador = 1;
					item.setColocacao(contador);
					DAO.getInstance().update(item);
					contador++;
					// EnviarEmail e = new EnviarEmail();
					// e.enviarEmail(item.getEmail());}
				} else {
					cargo = item.getCargo();
					contador = 1;
					item.setColocacao(contador);
					DAO.getInstance().update(item);
					contador++;
				}
			} else {
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				contador++;
				// EnviarEmail e = new EnviarEmail();
				// e.enviarEmail(item.getEmail());
			}
		}

	}
}
