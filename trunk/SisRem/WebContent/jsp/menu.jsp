<%@page import="javax.faces.context.FacesContext"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>


<a4j:form>

	<h:outputText value="Bem vindo #{usuarioLogado.nome}" />
	<br />
	<br />
	<rich:toolBar>

		<rich:dropDownMenu>
			<f:facet name="label">
				<h:panelGroup>
					<h:outputText value="Remoção" />
				</h:panelGroup>
			</f:facet>
			<rich:menuItem submitMode="ajax" value="Solicitar Remoção"
				action="#{servidorController.cadastrar}">
			</rich:menuItem>
			<rich:menuItem submitMode="ajax" value="Acompanhar Solicitação"
				action="#{servidorController.listarIntencoesSolicitante}">
			</rich:menuItem>

		</rich:dropDownMenu>

		<rich:dropDownMenu rendered="#{usuarioLogado.admin}">
			<f:facet name="label">
				<h:panelGrid cellpadding="0" cellspacing="0" columns="2"
					style="vertical-align:middle">
					<h:outputText value="Ranquear" />
				</h:panelGrid>
			</f:facet>
			<rich:menuItem submitMode="ajax" value="Ranquear"
				action="#{rankingController.cadastrar}">
			</rich:menuItem>
			<rich:menuItem submitMode="ajax" value="Aprovar Remoção"
				rendered="#{usuarioLogado.admin}"
				action="#{servidorController.listarIntencoes}">
			</rich:menuItem>
		</rich:dropDownMenu>

		<rich:dropDownMenu rendered="#{usuarioLogado.admin}">

			<f:facet name="label">
				<h:panelGrid cellpadding="0" cellspacing="0" columns="2"
					style="vertical-align:middle">
					<h:outputText value="FAQ" />
				</h:panelGrid>
			</f:facet>

			<rich:menuItem value="Cadastrar" action="#{duvidaController.nova}">
			</rich:menuItem>
			<rich:menuItem value="Listar" action="#{duvidaController.listar}">
			</rich:menuItem>


		</rich:dropDownMenu>
		<rich:toolBarGroup location="right">
			<rich:dropDownMenu>
				<f:facet name="label">
					<h:panelGroup>
						<h:outputText value="Sair" />
					</h:panelGroup>
				</f:facet>
				<rich:menuItem submitMode="ajax" value="Sair"
					action="#{srController.logout}" />
			</rich:dropDownMenu>
		</rich:toolBarGroup>

	</rich:toolBar>
</a4j:form>