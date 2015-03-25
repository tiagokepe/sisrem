
package br.com.cf.constantes;

import java.util.Date;

import br.com.cf.jsfUtil.DataUtil;


public abstract class Constantes {
		
	public static final Integer QTDE_MAXIMA_DE_DESTINOS = 3;
	public static final String DATA_FINAL_PRIMEIRA_FASE = DataUtil.format(new Date("20/03/2015"), "dd/MM/yyyy");
	
}

