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
<style>
.rich-table
{
	margin-left: 0px;
	margin-top: 15px;
}
</style>
<body>
	<f:view>
		<rich:panel>
			<jsp:directive.include file="menu.jsp" />
			<h:outputText value="Dúvidas Frequentes - FAQ"
				style="font-size: 22px; margin-bottom: 50px"></h:outputText>
				<h:messages />
			<h:form>
				<rich:dataTable value="#{duvidaController.listaDuvidas}" var="duvida"
					width="1080px" columnClasses="center" rows="15" reRender="ds">
					<f:facet name="header">
						<h:outputText value="Dúvidas Frequentes - FAQ" />
					</f:facet>
					<rich:column style="text-align: center" sortBy="#{duvida.pergunta}">
						<f:facet name="header">
							<h:outputText value="Pergunta" />
						</f:facet>
						<h:outputText value="#{duvida.pergunta}" />
					</rich:column>
					<rich:column sortBy="#{duvida.resposta}">
						<f:facet name="header">
							<h:outputText value="Resposta" />
						</f:facet>
						<h:outputText value="#{duvida.resposta}" escape="false"/>
					</rich:column>
					<rich:column style="text-align: center">
						<f:facet name="header">
							<h:outputText value="Ações" />
						</f:facet>
						<h:commandLink title="Editar"><h:graphicImage value="../images/edit.gif" alt="Editar" /></h:commandLink>
						<h:commandLink title="Excluir" style="margin-left: 10px;"><h:graphicImage value="../images/delete.gif" alt="Excluir" /> </h:commandLink>
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</h:form>
		</rich:panel>
	</f:view>
</body>
</html>