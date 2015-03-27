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
				<a4j:form id="form">
				<center>
					<rich:messages layout="list" errorLabelClass="errorLabel"
						style="top:auto;" infoLabelClass="infoLabel">
						<f:facet name="infoMarker">
							<h:graphicImage value="../images/passed.gif" />
						</f:facet>
						<f:facet name="errorMarker">
							<h:graphicImage value="../images/error.gif" />
						</f:facet>
					</rich:messages>
				</center>
			
				<rich:dataTable id="listaDuvidas" value="#{duvidaController.listaDuvidas}" var="duvida"
					width="1080px" columnClasses="center" rows="15" reRender="ds">
					<f:facet name="header">
						<h:outputText value="Dúvidas Frequentes - FAQ" />
					</f:facet>
					<rich:column style="text-align: center" sortBy="#{duvida.enunciado}">
						<f:facet name="header">
							<h:outputText value="Enunciado" />
						</f:facet>
						<h:outputText value="#{duvida.enunciado}" />
					</rich:column>
					<rich:column sortBy="#{duvida.descricao}">
						<f:facet name="header">
							<h:outputText value="Descrição" />
						</f:facet>
						<h:outputText value="#{duvida.descricao}" escape="false"/>
					</rich:column>
					<rich:column style="text-align: center" width="50">
						<f:facet name="header">
							<h:outputText value="Ações" />
						</f:facet>
						<a4j:commandLink action="#{duvidaController.editar}" title="Editar" reRender="form, messages, listaDuvidas">
							<h:graphicImage value="../images/edit.gif" style="border:0"
								id="edit" alt="Editar" />
						</a4j:commandLink>
						<a4j:commandLink action="#{duvidaController.excluir}" title="Excluir" reRender="form, messages, listaDuvidas">
							<h:graphicImage value="../images/delete.gif" style="border:0; margin-left: 10px;"
								id="delete" alt="Exlcuir" />
						</a4j:commandLink>
					</rich:column>
					<f:facet name="footer">
						<rich:datascroller id="ds"></rich:datascroller>
					</f:facet>
				</rich:dataTable>
			</a4j:form>
		</rich:panel>
	</f:view>
</body>
</html>