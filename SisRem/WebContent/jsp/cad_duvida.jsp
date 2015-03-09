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
		<rich:panel>
			<jsp:directive.include file="menu.jsp" />
				<h:outputText value="Cadastro FAQ" style="font-size: 22px; margin-bottom: 50px"></h:outputText>
				<a4j:form id="form">
					<rich:messages id="messages" layout="list" errorLabelClass="errorLabel"
						style="top:auto;" infoLabelClass="infoLabel">
						<f:facet name="infoMarker">
							<h:graphicImage value="../images/passed.gif" />
						</f:facet>
						<f:facet name="errorMarker">
							<h:graphicImage value="../images/error.gif" />
						</f:facet>
					</rich:messages>
				
					<h:panelGrid columns="2" style="margin-left: 0px; padding-left: 0px;">
						<h:outputText value="Dúvida:" />
						<h:inputText value="#{duvidaController.duvida.pergunta}" required="true" size="60"
							requiredMessage="Campo Dúvida obrigatório!" />
						<h:outputText value="Resposta:" />
				       <rich:editor id="editor" value="#{duvidaController.duvida.resposta}" required="true" requiredMessage="Campo Resposta obrigatório!">
				          <f:param name="theme_advanced_buttons1" value="bold,italic,underline, cut,copy,paste,pasteword"/>
				          <f:param name="theme_advanced_toolbar_location" value="top"/>                               
				          <f:param name="theme_advanced_toolbar_align" value="left"/>
			          </rich:editor>
					</h:panelGrid>
				<br />
				<h:commandButton value="Limpar" type="reset" style="padding:5px 10px 5px 10px;border-radius:5px; margin: 0px 5px 0px 55px"/>
				<a4j:commandButton value="Cadastrar" action="#{duvidaController.cadastrar}"
					reRender="form, messages">
				</a4j:commandButton>
			</a4j:form>
		</rich:panel>
	</f:view>
</body>
</html>