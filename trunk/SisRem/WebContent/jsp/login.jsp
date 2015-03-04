<%@page import="javax.faces.context.FacesContext"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>


<body>
	<f:view>
		<center>
	
				<a4j:loadScript src="../js/script.js" />
			
			<a4j:loadScript src="../js/script.js" />
			<a4j:form id="form">
				<rich:panel>
					<h:panelGrid columns="1">
					<h:outputText value="SisRem" styleClass="negrito" style="font-size:20px"/>
					<rich:messages layout="list" errorLabelClass="errorLabel"
						style="top:auto;" infoLabelClass="infoLabel">
						<f:facet name="infoMarker">
							<h:graphicImage value="../images/passed.gif" />
						</f:facet>
						<f:facet name="errorMarker">
							<h:graphicImage value="../images/error.gif" />
						</f:facet>
					</rich:messages>
					
					
					<h:outputText value="Por favor entre com usuario do SIPAC:" />
					<h:inputText value="#{usuarioController.usuario.login}" required="true" requiredMessage="Campo usuário obrigatório!" />
					<h:outputText value="Por favor entre com sua senha:" />
					<h:inputSecret value="#{usuarioController.usuario.senha}"
						required="true" requiredMessage="Senha é obrigatório!"></h:inputSecret>
					</h:panelGrid>
					<br/>
					<a4j:commandButton value="Entrar"
						action="#{usuarioController.login}" reRender="form, messages">
					</a4j:commandButton>
					<br/><br/>
					<h:outputLink value="https://sigadmin.ifpr.edu.br/admin/auto_cadastro/form.jsf">
					  <f:verbatim>Clique aqui caso não possua acesso</f:verbatim>
					</h:outputLink>
					<br /><br/>
					<h:outputText
						value="Por favor utilize os navegadores Firefox ou Chrome." />
					<center><br /><br/>
						<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
					</center>
				</rich:panel>
	
			</a4j:form>
		</center>
	</f:view>
</body>
</html>