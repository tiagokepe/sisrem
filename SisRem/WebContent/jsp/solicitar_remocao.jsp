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
				<center>
				<h:outputText value="Cadastro de Intenção de Remoção"
				style="font-size: 22px;"></h:outputText>
				</center>

				<h:panelGrid columns="2" style="margin-left:0; line-height:20px;">
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



					<h:outputText value="Unidade Destino:" style="font-weight: bold;" />
					<h:selectOneMenu value="#{servidorController.intencao.destino}"
						required="true" requiredMessage="Selecione o Unidade de Destino!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						<f:selectItems value="#{servidorController.unidadeList}" />
					</h:selectOneMenu>

					<h:outputText value="Link para o curriculo lattes:"
						style="font-weight: bold;"
						rendered="#{servidorController.servidor.categoria == 'Docente'}" />
					<h:inputText
						rendered="#{servidorController.servidor.categoria == 'Docente'}"
						value="#{servidorController.intencao.lattes}" size="50"
						required="true"
						requiredMessage="O campo Link para o curriculo lattes é obrigatório:">
					</h:inputText>


					<h:outputText value="Justificativa: " style="font-weight: bold;" />
					<h:inputTextarea
						value="#{servidorController.intencao.justificativa}" cols="78"
						rows="5" required="true"
						requiredMessage="O campo Justificativa é obrigatório:">
					</h:inputTextarea>

					<br />

					<a4j:commandButton value="Adicionar"
						action="#{servidorController.adicionarIntencao}" reRender="form" />


				</h:panelGrid>
				<br />
				<br />
				<h:outputText value="Opções de Destinos já cadastradas:"
					style="font-weight: bold;"
					rendered="#{ not empty servidorController.intencaoList}" />

				<rich:dataTable id="listarIntencoes"
					rendered="#{ not empty servidorController.intencaoList}"
					value="#{servidorController.intencaoList}" var="list"
					title="Lista de Intenções" width="1080px" columnClasses="center"
					rows="10" reRender="ds">


					<rich:column width="120px">
						<f:facet name="header">
							<h:outputText value="Data Solicitação" />
						</f:facet>
						<h:outputText value="#{list.dataInscricao}">
							<f:convertDateTime pattern="dd/MM/yyyy hh:mm:ss" />
						</h:outputText>
					</rich:column>

					<rich:column width="230px">
						<f:facet name="header">
							<h:outputText value="Destino" />
						</f:facet>
						<h:outputText value="#{list.destino}" />
					</rich:column>

					<rich:column width="600px">
						<f:facet name="header">
							<h:outputText value="Justificativa" />
						</f:facet>
						<h:outputText value="#{list.justificativa}" />
					</rich:column>

					<rich:column width="140px">
						<f:facet name="header">
							<h:outputText value="Status" />
						</f:facet>
						<h:outputText value="#{list.status}" />
					</rich:column>

					<rich:column width="30px">
						<f:facet name="header">
							<h:outputText value="Excluir" />
						</f:facet>
						<a4j:commandLink action="#{servidorController.excluirIntencao}"
							reRender="form" ajaxSingle="true">
							<h:graphicImage value="../images/delete.gif" style="border:0"
								id="delete" />

						</a4j:commandLink>
						<rich:toolTip for="excluir" value="Excluir" />
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