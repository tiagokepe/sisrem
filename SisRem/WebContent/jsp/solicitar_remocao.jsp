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


				<rich:messages layout="list" errorLabelClass="errorLabel"
					style="top:auto;" infoLabelClass="infoLabel">
					<f:facet name="infoMarker">
						<h:graphicImage value="../images/passed.gif" />
					</f:facet>
					<f:facet name="errorMarker">
						<h:graphicImage value="../images/error.gif" />
					</f:facet>
				</rich:messages>


				<h:panelGrid columns="2" style="margin-left:0">
					<h:outputText value="Siape:" />
					<h:outputText value="#{servidorController.servidor.siape}" />
					<h:outputText value="Nome Servidor:" />
					<h:outputText value="#{servidorController.servidor.nome}" />
					<h:outputText value="Data de Nascimento:" />
					<h:outputText value="#{servidorController.servidor.dataNascimento}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputText value="Unidade Origem:" />
					<h:outputText value="#{servidorController.servidor.unidade}" />
					<h:outputText value="Categoria:" />
					<h:outputText value="#{servidorController.servidor.categoria}" />
					<h:outputText value="Data de Admissão:" />
					<h:outputText value="#{servidorController.servidor.dataAdmissao}">
						<f:convertDateTime pattern="dd/MM/yyyy" />
					</h:outputText>
					<h:outputText value="Cargo:" />
					<h:outputText value="#{servidorController.servidor.cargo}" />
					<h:outputText value="Celular:" />
					<h:outputText value="#{servidorController.servidor.celular}" />
					<h:outputText value="Telefone:" />
					<h:outputText value="#{servidorController.servidor.telefone}" />
					<h:outputText value="Email:" />
					<h:outputText value="#{servidorController.servidor.email}" />


					<h:outputText value="Selecione o Edital:"
						style="font-weight: bold;" />

					<h:selectOneMenu value="" required="true"
						requiredMessage="Selecione o Edital!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
					</h:selectOneMenu>


					<h:outputText value="Unidade Destino:" style="font-weight: bold;" />
					<h:selectOneMenu value="" required="true"
						requiredMessage="Selecione o Unidade de Destino!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.unidadeList}" />
					</h:selectOneMenu>
					
					<h:outputText value="Área:" style="font-weight: bold;" />
					<h:selectOneMenu value="" required="true"
						requiredMessage="Selecione a Área!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
					
					</h:selectOneMenu>
					

					<h:outputText value="Justificativa: " />
					<h:inputTextarea value="" cols="78" rows="5" required="true"
						requiredMessage="O campo Justificativa é obrigatório:">
					</h:inputTextarea>

					<br />

					<a4j:commandButton value="Adicionar"
						action="#{enqueteController.adicionar}" reRender="form" />

					
					</h:panelGrid>
					<br/><hr><br/>
					
					<h:panelGrid columns="1">
					
					
					<rich:dataTable value="#{meuPrimeiroDataTable.resultado}" var="item" style="margin-left:0px">
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="OPÇÃO" />
					
					</f:facet>
					
					<h:outputText value="#{item.id}" />
					
					</rich:column><rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="AREA" />
					
					</f:facet>
					
					<h:outputText value="#{item.id}" />
					
					</rich:column>							
				
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="CAMPUS DESTINO" />
					
					</f:facet>
					
					<h:outputText value="#{item.id}" />
					
					</rich:column>
																					
				
				</rich:dataTable>
				<br/>
				<a4j:commandButton value="Confirmar e Salvar"
						action="#{enqueteController.adicionar}" reRender="form" />
				
				</h:panelGrid>	
				<br/><br/>
					
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>


			</a4j:form>
		</rich:panel>
	</f:view>
</body>
</html>