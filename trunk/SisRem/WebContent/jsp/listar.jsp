<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paraná</title>
</head>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />

<style type="text/css">
body {
	background-position: 250px 0;
	background-color: #DDE9CD;
}

.rich-panel {
	width: 1300px;
	font-size: 15px;
	background: #fff url(../images/marca.png) 40px 18px no-repeat;
	padding: 100px 2.857142857rem;
	margin-top: 3.428571429rem;
	border-radius: 20px;
	border: none;
	box-shadow: 0 2px 6px rgba(100, 100, 100, 0.3);
}
</style>

<body>
	<f:view>
	<rich:panel>
		<center>
			<a4j:form id="form">
				
					<a4j:status>
						<f:facet name="start">
							<h:graphicImage value="../images/ajax-loader.gif" />
						</f:facet>
					</a4j:status>

					<rich:messages layout="list">
						<f:facet name="errorMarker">
							<h:graphicImage value="../images/error.gif" />
						</f:facet>
					</rich:messages>

					<rich:dataTable id="listarProjetos"
						value="#{candidatoController.candidatoList}" var="list"
						width="900px" columnClasses="center" rows="15" reRender="ds">
						<rich:column width="50px" sortBy="#{list.nome}"
							filterBy="#{list.nome}" filterEvent="onkeyup">
							<f:facet name="header">
								<h:outputText value="Nome" />
							</f:facet>
							<h:outputText value="#{list.nome}" />
						</rich:column>

						<rich:column width="200px" sortBy="#{list.instituicao}"
							filterBy="#{list.instituicao}" filterEvent="onkeyup">
							<f:facet name="header">
								<h:outputText value="Instituição" />
							</f:facet>
							<h:outputText value="#{list.instituicao}" />
						</rich:column>

						<rich:column width="200px" sortBy="#{list.funcao}"
							filterBy="#{list.funcao}" filterEvent="onkeyup">
							<f:facet name="header">
								<h:outputText value="Função" />
							</f:facet>
							<h:outputText value="#{list.funcao}" />
						</rich:column>

						<rich:column width="200px" sortBy="#{list.email}"
							filterBy="#{list.email}" filterEvent="onkeyup">
							<f:facet name="header">
								<h:outputText value="E-mail" />
							</f:facet>
							<h:outputText value="#{list.email}" />
						</rich:column>

						<rich:column width="200px" sortBy="#{list.telefone}"
							filterBy="#{list.telefone}" filterEvent="onkeyup">
							<f:facet name="header">
								<h:outputText value="Telefone" />
							</f:facet>
							<h:outputText value="#{list.telefone}" />
						</rich:column>



						<f:facet name="footer">
							<rich:datascroller id="ds"></rich:datascroller>
						</f:facet>
					</rich:dataTable>
			
				</a4j:form>
			</rich:panel>	
		</center>
	</f:view>
</body>
</html>