package br.com.cf.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.cf.entity.Usuario;

public class EnviarEmail {
	private String remetente;
	private String destinatario;
	private String smtpHost;
	private String porta;
	private String assunto;
	private Properties propriedades;
	private Session sessao;
	private static String usuario;
	private static String senha;
	private String conteudoDoEmail;

	private static class Autenticacao extends Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(usuario, senha);
		}
	}

	public EnviarEmail() {
	}

	public void enviarEmail(Usuario usuario) {
		String remetente = "clima.organizacional@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String senha = "3nqu3t31f";

		assunto = "Pesquisa de Clima Organizacional do IFPR";
		conteudoDoEmail = "Prezado (a) colega, estamos realizando uma Pesquisa de Clima Organizacional do IFPR. ";
		conteudoDoEmail += "\n\n Nosso objetivo é obter informações mais detalhadas e específicas sobre o que pensam os servidores docentes e administrativos em assuntos como: relacionamento interpessoal, ética, liderança, comunicação, gestão democrática entre outros. ";
		conteudoDoEmail += "\n\n A partir dos resultados obtidos com essa pesquisa, pretendemos adotar algumas ações com o objetivo de proporcionar um melhor ambiente de trabalho a todos. ";
		conteudoDoEmail += "\n\n O questionário é anônimo e nenhuma informação pessoal será solicitada. No entanto, para fins de analise dos dados é necessário apenas que você identifique o campus / Setor da Reitoria no qual você trabalha. ";
		conteudoDoEmail += "\n\n Para o sucesso dessa pesquisa solicitamos que você avalie e responda as questões com o máximo de sinceridade. Lembre-se de que não existem respostas certas ou erradas. Também é importante que você esteja em um ambiente calmo e que responda sozinho(a) essa pesquisa. ";
		conteudoDoEmail += "\n\n Contamos com sua participação! ";
		conteudoDoEmail += "\n\n Vamos organizar os resultados na última semana de setembro de 2013. Por isso, aguardamos sua avaliação até o dia 23 de setembro.  ";
		conteudoDoEmail += "\n\n Jesué Graciliano da Silva  ";
		conteudoDoEmail += "\n\n Reitor pro tempore do IFPR  ";
		conteudoDoEmail += "\n\n O link para acesso é: http://200.17.98.51:8080/climaorganizacional/faces/jsp/index.jsp";
		conteudoDoEmail += "\n\n Sua senha de acesso é :" + usuario.getSenha();
		conteudoDoEmail += "\n\n Por favor não responda esse e-mail. ";

//		try {
//			@SuppressWarnings("unused")
//			EnviarEmail enviar = new EnviarEmail(remetente, usuario.getEmail(),
//					assunto, smtpHost, porta, remetente, senha, conteudoDoEmail);
//			System.out.println(usuario.getEmail() + " - SUCESSO!");
//		} catch (Exception e) {
//			System.out.println(usuario.getEmail() + " - FALHA!");
//		}
	}

	@SuppressWarnings("static-access")
	public EnviarEmail(String remetente, String destinatario, String assunto,
			String smtpHost, String porta, String usuario, String senha,
			String conteudoDoEmail) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.smtpHost = smtpHost;
		this.porta = porta;
		this.usuario = usuario;
		this.senha = senha;
		this.conteudoDoEmail = conteudoDoEmail;
		this.propriedades = System.getProperties();
		this.propriedades.put("mail.smtp.host", this.smtpHost);
		this.propriedades.put("mail.smtp.auth", "true");
		this.propriedades.put("mail.debug", "false");
		this.propriedades.put("mail.smtp.debug", "false");
		this.propriedades.put("mail.smtp.port", this.porta);
		this.propriedades.put("mail.smtp.starttls.enable", "false");
		this.propriedades.put("mail.smtp.socketFactory.port", this.porta);
		this.propriedades.put("mail.smtp.socketFactory.fallback", "false");
		this.propriedades.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		this.propriedades.put("mail.smtp.user",
				"clima.organizacional@ifpr.edu.br");
		Authenticator auth = new Autenticacao();
		this.sessao = Session.getDefaultInstance(this.propriedades, auth);
		try {
			Message mensagem = new MimeMessage(this.sessao);
			mensagem.setSubject(this.assunto);
			mensagem.setFrom(new InternetAddress(this.remetente));
			mensagem.addRecipient(Message.RecipientType.TO,
					new InternetAddress(this.destinatario));
			mensagem.setText(this.conteudoDoEmail);
			Transport.send(mensagem);
		} catch (Exception err) {
			System.out.println("Erro ao enviar mensagem");
		}
	}

}