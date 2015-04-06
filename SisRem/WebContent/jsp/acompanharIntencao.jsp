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
	<%
		/*
		 /*if (FacesContext.getCurrentInstance().getExternalContext()
		 .getSessionMap().get("Logado") == null) {
		 FacesContext.getCurrentInstance().getExternalContext()
		 .redirect("index.jsp");
		 }
		 */
	%>
	<f:view>
		<rich:panel>
			<jsp:directive.include file="menu.jsp" />
			<a4j:loadScript src="../js/script.js" />

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

				<rich:dataTable id="listarIntencoes"
					rendered="#{ not empty servidorController.intencaoList}"
					value="#{servidorController.intencaoList}" var="list"
					title="Lista de Intenções" width="800px" columnClasses="center"
					rows="10" reRender="ds">


					<rich:column width="100px" sortBy="#{list.destino}" filterBy="#{list.destino}" filterEvent="onkeyup" >
						<f:facet name="header">
							<h:outputText value="Unidade Destino" />
						</f:facet>
						<h:outputText value="#{list.destino}">
						</h:outputText>
					</rich:column>


					<rich:column width="100px" >
						<f:facet name="header">
							<h:outputText value="Fase" />
						</f:facet>
						<h:outputText value="#{list.fase}" />
					</rich:column>

					<rich:column width="100px" >
						<f:facet name="header">
							<h:outputText value="Colocação" />
						</f:facet>
						<h:outputText value="#{list.colocacao}" />
					</rich:column>
					
					
					<rich:column width="100px" >
						<f:facet name="header">
							<h:outputText value="Nome" />
						</f:facet>
						<h:outputText value="#{list.nome}" />
					</rich:column>
					
					
					<rich:column width="200px" >
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<h:outputText value="#{list.status}" />
					</rich:column>

				</rich:dataTable>


				<br />
				<br />

				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>


			</a4j:form>
		</rich:panel>
	</f:view>
</body>
</html>