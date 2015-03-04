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
	<f:view>
		<center>
			<a4j:loadScript src="../js/script.js" />
		</center>
		<a4j:loadScript src="../js/script.js" />
		<a4j:form id="form">
			<rich:panel>
				<rich:messages layout="list" errorLabelClass="errorLabel"
					style="top:auto;" infoLabelClass="infoLabel">
					<f:facet name="infoMarker">
						<h:graphicImage value="../images/passed.gif" />
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="../images/error.gif" />
					</f:facet>
				</rich:messages>
				
				<h:outputText value="Por favor entre com sua senha:" />
				<br />
				<h:inputSecret value="#{usuarioController.usuario.senha}"
					required="true" requiredMessage="Senha é obrigatório!"></h:inputSecret>
				<br />
				<a4j:commandButton value="Entrar"
					action="#{usuarioController.login}" reRender="form, messages">
				</a4j:commandButton>
				<br />
				<h:outputText
					value="Por favor utilize os navegadores Firefox ou Chrome." />
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>
			</rich:panel>

		</a4j:form>
	</f:view>
</body>
</html>