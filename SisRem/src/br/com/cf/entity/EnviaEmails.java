package br.com.cf.entity;

import java.util.ArrayList;
import java.util.List;

import br.com.cf.dao.DAO;
import br.com.cf.util.EnviarEmail;

public class EnviaEmails {

	public EnviaEmails() {
	}

	public static void main(String[] args) {
		


		List<Usuario> usuarioList = new ArrayList<Usuario>();
		
		
		usuarioList =  DAO.getInstance().list(Usuario.class);
		
		for(Usuario item:usuarioList){
			EnviarEmail e = new EnviarEmail();
			e.enviarEmail(item);
		}
		
	}
}
