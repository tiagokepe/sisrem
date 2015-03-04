package br.com.cf.jsfUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;


public class DataUtil {

	/** 
	   * Armazena inst�ncia de <b>DateFormat</b> com o formato de data do padr�o 
	   * definido. 
	   */  
	  protected static DateFormat dateFormat = null;  
	  
	  /** 
	   * Armazena inst�ncia de <b>DateFormat</b> com o formato da data do padr�o 
	   * definido. 
	   */  
	  protected static DateFormat dateHourFormat = null;  
	  
	  /** 
	   * Armazena inst�ncia de <b>Locale</b>, que define informa��es de pa�s 
	   * e idioma do padr�o definido. 
	   */  
	  protected static Locale locale = null;  
	  
	  /** 
	   * Construtor. 
	   */  
	  protected void SimpleDatePattern() {  
	  }  
	  
	  /** 
	   * Define o padr�o a ser trabalhado para Brasileiro.<br> 
	   * O padr�o Brasileiro define:<br> 
	   * <li>Data e hora para: dd/MM/yyyy HH:mm:ss 
	   * <li>Data para: dd/MM/yyyy 
	   * <li>Locale: "pt", "BR" 
	   */  
	  public static void setBrazilianPattern() {  
	    locale = new Locale("pt", "BR");  
	    dateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);  
	    dateHourFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", locale);  
	  }  
	  
	  /** 
	   * Define o padr�o a ser trabalhado para Brasileiro.<br> 
	   * O padr�o Brasileiro define:<br> 
	   * <li>Data e hora para: MM/dd/yyyy hh:mm:ss aa 
	   * <li>Data para: MM/dd/yyyy 
	   * <li>Locale: Locale.US 
	   */  
	  public static void setAmericanPattern() {  
	    locale = Locale.US;  
	    dateFormat = new SimpleDateFormat("MM/dd/yyyy", locale);  
	    dateHourFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa", locale);  
	  }  
	  
	  
	  /** 
	   * Retorna uma c�pia da inst�ncia <b>dateFormat</b> do padr�o definido. 
	   * @return c�pia de dateFormat 
	   */  
	  public static DateFormat getDateFormat() {  
	    if ( locale == null ) setBrazilianPattern();  
	    return (DateFormat)dateFormat.clone();  
	  }  
	  
	  /** 
	   * Retorna uma c�pia da inst�ncia <b>dateHourFormat</b> do padr�o definido. 
	   * @return c�pia de dateHourFormat 
	   */  
	  public static DateFormat getDateHourFormat() {  
	    if ( locale == null ) setBrazilianPattern();  
	    return (DateFormat)dateHourFormat.clone();  
	  }  
	  
	  /** 
	   * Instancia um <b>GregorianCalendar</b> a partir da data e formato 
	   * informados. 
	   * @param data data a ser analisada 
	   * @param formato formato da data. Exemplo: yyyy/MM/dd HH:mm:ss 
	   * @return inst�ncia de <b>GregorianCalendar</b> 
	   * @throws ParseException em caso de erros na convers�o da data 
	 * @throws  
	   */  
	  public static GregorianCalendar parse(String data, String formato)  
	      throws ParseException {  
	  
	    if ( locale == null ) setBrazilianPattern();  
	    SimpleDateFormat f = (SimpleDateFormat)dateFormat.clone();  
	    f.applyPattern(formato);  
	    GregorianCalendar g = new GregorianCalendar();  
	    g.setTime( f.parse(data) );  
	    f = null;  
	    return g;  
	  }  
	  
	  /** 
	   * Instancia um <bGregorianCalendar</b> a partir da data informada para 
	   * o padr�o de data definido. 
	   * @param data data a ser analisada 
	   * @return inst�ncia de <b>GregorianCalendar</b> 
	   * @throws ParseException em caso de erros na convers�o da data 
	   */  
	  public static GregorianCalendar parseDate(String data)  
	      throws ParseException {  
	  
	    if ( locale == null ) setBrazilianPattern();  
	    GregorianCalendar g = new GregorianCalendar();  
	    g.setTime( dateFormat.parse(data) );  
	    return g;  
	  }  
	  
	  /** 
	   * Instancia um <bGregorianCalendar</b> a partir da data informada para 
	   * o padr�o de data e hora definido. 
	   * @param data data a ser analisada 
	   * @return inst�ncia de <b>GregorianCalendar</b> 
	   * @throws ParseException em caso de erros na convers�o da data 
	   */  
	  public static GregorianCalendar parseDateHour(String data)  
	      throws ParseException {  
	  
	    if ( locale == null ) setBrazilianPattern();  
	    GregorianCalendar g = new GregorianCalendar();  
	    g.setTime( dateHourFormat.parse(data) );  
	    return g;  
	  }  
	  
	  /** 
	   * Retorna inst�ncia de <b>Calendar</b> utilizado no padr�o definido. 
	   * @return inst�ncia de <b>Calendar</b> 
	   */  
	  public static Calendar getCalendar() {  
	    if ( locale == null ) setBrazilianPattern();  
	    return new GregorianCalendar( locale );  
	  }  
	  
	  /** 
	   * Retorna c�pia da inst�ncia <b>locale</b> do padr�o definido. 
	   * @return c�pia de <b>locale</b> 
	   */  
	  public static Locale getLocale() {  
	    if ( locale == null ) setBrazilianPattern();  
	    return (Locale)locale.clone();  
	  }  
	  
	  /** 
	   * Formata uma inst�ncia de <b>Date</b> para String, no formato de data do padr�o 
	   * definido. 
	   * @param data data a ser formatada 
	   * @return data formatada 
	   */  
	  public static String formatDate(Date data) {  
	    if ( locale == null ) setBrazilianPattern();  
	    return dateFormat.format(data);  
	  }  
	  
	  /** 
	   * Formata uma inst�ncia de <b>Date</b> para String, no formato de data do padr�o 
	   * definido. 
	   * @param data data a ser formatada 
	   * @return data formatada 
	   */  
	  public static String formatDate(GregorianCalendar data) {  
	    return formatDate(data.getTime());  
	  }  
	  
	  
	  /** 
	   * Formata uma inst�ncia de <b>Date</b> para String, no formato de data e 
	   * hora do padr�o definido. 
	   * @param data data e hora a ser formatada 
	   * @return data e hora formatada 
	   */  
	  public static String formatDateHour(Date data) {  
	    if ( locale == null ) setBrazilianPattern();  
	    return dateHourFormat.format(data);  
	  }  
	  
	  /** 
	   * Formata uma inst�ncia de <b>Date</b> para String, no formato de data e 
	   * hora do padr�o definido. 
	   * @param data data e hora a ser formatada 
	   * @return data e hora formatada 
	   */  
	  public static String formatDateHour(GregorianCalendar data) {  
	    return formatDateHour(data.getTime());  
	  }  
	  
	  /** 
	   * Formata uma inst�ncia de <b>Date</b> para String, no formato de data/hora 
	   * informado. 
	   * @param data data/hora a ser formatada 
	   * @param formato da data/hora. Exemplo: dd/MM/yyyy hh:mm:ss 
	   * @return data/hora formatada 
	   */  
	  public static String format(Date data, String formato) {  
	    if ( locale == null ) setBrazilianPattern();  
	    SimpleDateFormat f = (SimpleDateFormat) dateFormat.clone();  
	    f.applyPattern(formato);  
	    return f.format(data);  
	  }  
	  
	  /** 
	   * Formata uma inst�ncia de <b>GregorianCalendar</b> para String, no formato 
	   * de data/hora informado. 
	   * @param data data/hora a ser formatada 
	   * @param formato da data/hora. Exemplo: dd/MM/yyyy hh:mm:ss 
	   * @return data/hora formatada 
	   */  
	  public static String format(GregorianCalendar data, String formato) {  
	    return format(data.getTime(), formato);  
	  }  
	  
	  public static GregorianCalendar toGregorianCalendar(Date data) {  
	    if (data == null) return null;  
	    GregorianCalendar dataSch = new GregorianCalendar();  
	    dataSch.setTime(data);  
	    return dataSch;  
	  }  
	  
	  /**
	   * Sql DATE 
	   */
	  public static void setSqlPattern() {  
		    dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		    dateHourFormat = new SimpleDateFormat("yyyy-MM-dd");  
		  }  
}
