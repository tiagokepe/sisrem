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
		int contador = 0;
		String destino = intencaoList.get(0).getDestino();
		String cargo = intencaoList.get(0).getCargo();
		for (Intencao item : intencaoList) {
			if (item.getDestino().equals(destino)
					&& item.getCargo().equals(cargo)) {
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
			} else if (item.getDestino().equals(destino)
					&& !(item.getCargo().equals(cargo))) {
				cargo = item.getCargo();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
			} else if (!(item.getDestino().equals(destino))
					&& (item.getCargo().equals(cargo))) {
				destino = item.getDestino();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
			}
			// enviar email}
			else {
				destino = item.getDestino();
				cargo = item.getCargo();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
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
		int contador = 0;
		String destino = intencaoList.get(0).getDestino();
		String cargo = intencaoList.get(0).getCargo();
		for (Intencao item : intencaoList) {
			if (item.getDestino().equals(destino)
					&& item.getCargo().equals(cargo)) {
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
			} else if (item.getDestino().equals(destino)
					&& !(item.getCargo().equals(cargo))) {
				cargo = item.getCargo();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
			} else if (!(item.getDestino().equals(destino))
					&& (item.getCargo().equals(cargo))) {
				destino = item.getDestino();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
			}
			// enviar email}
			else {
				destino = item.getDestino();
				cargo = item.getCargo();
				contador = 0;
				contador++;
				item.setColocacao(contador);
				DAO.getInstance().update(item);
				// enviar email
			}

		}

	}
}
