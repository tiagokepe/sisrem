package br.com.cf.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.cf.entity.Intencao;

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

	public void enviarEmail(Intencao intencao) {
		String remetente = "remocao@ifpr.edu.br";
		String smtpHost = "smtp.gmail.com";
		String porta = "465";
		String senha = "";

		assunto = "Cadastro de Intenção de Remoção";
		conteudoDoEmail = "Prezado (a) "+intencao.getNome();
		conteudoDoEmail += "\n\n Você é o "+ intencao.getColocacao() +"º colocado para remoção para a unidade: "+intencao.getDestino();
		conteudoDoEmail += "\n\n Assim que houver uma vaga a PROGEPE entrará em contato";
		try {
			@SuppressWarnings("unused")
			EnviarEmail enviar = new EnviarEmail(remetente, intencao.getEmail(),
					assunto, smtpHost, porta, remetente, senha, conteudoDoEmail);
		} catch (Exception e) {
		}
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