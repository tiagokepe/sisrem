<%@page import="javax.faces.context.FacesContext"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>
<style type="text/css">
body {
	background-position: 250px 0;
	background-color: #DDE9CD;
}

.rich-panel {
	width: 1300px;
	font-size: 15px;
	background: #fff url(../images/topo.png) 40px 18px no-repeat;
	padding: 100px 2.857142857rem;
	margin-top: 3.428571429rem;
	border-radius: 20px;
	border: none;
	box-shadow: 0 2px 6px rgba(100, 100, 100, 0.3);
}
</style>

<body>
	<%
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("Logado") == null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("index.jsp");
		}
	%>
	<f:view>
		<center>
			<a4j:loadScript src="../js/script.js" />
		</center>
		<a4j:loadScript src="../js/script.js" />
		<a4j:form id="form">
			<rich:panel>

				<h:outputText
					value="Prezado (a) colega, estamos realizando uma Pesquisa de Clima Organizacional do IFPR." />
				<br />
				<br />
				<h:outputText
					value="Nosso objetivo � obter informa��es mais detalhadas e espec�ficas sobre o que pensam os servidores docentes e administrativos em assuntos como: relacionamento interpessoal, �tica, lideran�a, comunica��o, gest�o democr�tica entre outros." />
				<br />
				<br />
				<h:outputText
					value="A partir dos resultados obtidos com essa pesquisa, pretendemos adotar algumas a��es com o objetivo de proporcionar um melhor ambiente de trabalho a todos." />
				<br />
				<br />
				<h:outputText
					value="O question�rio � an�nimo e nenhuma informa��o pessoal ser� solicitada. No entanto, para fins de analise dos dados � necess�rio apenas que voc� identifique o campus / Setor da Reitoria no qual voc� trabalha." />
				<br />
				<br />
				<h:outputText
					value="Para o sucesso dessa pesquisa solicitamos que voc� avalie e responda as quest�es com o m�ximo de sinceridade. Lembre-se de que n�o existem respostas certas ou erradas. Tamb�m � importante que voc� esteja em um ambiente calmo e que responda sozinho(a) essa pesquisa." />
				<br />
				<br />
				<h:outputText value="Contamos com sua participa��o!" />
				<br />
				<br />
				<h:outputText
					value="Vamos organizar os resultados na �ltima semana de setembro de 2013. Por isso, aguardamos sua avalia��o at� o dia 23 de setembro." />
				<br />
				<br />
				<h:outputText value="Jesu� Graciliano da Silva" />
				<br />
				<br />
				<h:outputText value="Reitor pro tempore do IFPR" />
				<br />
				<br />
			
				<rich:messages layout="list" errorLabelClass="errorLabel"
						style="top:auto;" infoLabelClass="infoLabel">
						<f:facet name="infoMarker">
							<h:graphicImage value="../images/passed.gif" />
						</f:facet>
						<f:facet name="errorMarker">
							<h:graphicImage value="../images/error.gif" />
						</f:facet>
					</rich:messages>
				<a4j:commandButton value="Clique aqui para responder"
					action="#{enqueteController.cadastrarNovo}" reRender="form, messages">
				</a4j:commandButton>
				<br/>
				<h:outputText value="Por favor utilize os navegadores Firefox ou Chrome." />
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>
			</rich:panel>
		</a4j:form>
	</f:view>
</body>
</html>