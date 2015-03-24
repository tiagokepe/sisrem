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
	<%/*
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
		<center>
			<a4j:loadScript src="../js/script.js" />
		</center>
		<a4j:loadScript src="../js/script.js" />
		<a4j:form id="form">
			
		
		<br/>
				<rich:dataTable id="listarIntencoes"	
					value="#{servidorController.intencaoList}" var="list"
					title="Lista de Intenções" width="1000px" columnClasses="center"
					rows="10" reRender="ds">


					<rich:column width="100px">
						<f:facet name="header">
							<h:outputText value="Data Solicitação" />
						</f:facet>
						<h:outputText value="#{list.dataInscricao}">
							<f:convertDateTime pattern="dd/MM/yyyy hh:mm:ss" />
						</h:outputText>
					</rich:column>

					<rich:column width="200px">
						<f:facet name="header">
							<h:outputText value="Destino" />
						</f:facet>
						<h:outputText value="#{list.destino}" />
					</rich:column>

					<rich:column width="200px"
						rendered="#{servidorController.servidor.categoria == 'Docente'}">
						<f:facet name="header">
							<h:outputText value="Area" />
						</f:facet>
						<h:outputText value="#{list.area}" />
					</rich:column>

					<rich:column width="600px">
						<f:facet name="header">
							<h:outputText value="Justificativa" />
						</f:facet>
						<h:outputText value="#{list.justificativa}" />
					</rich:column>

					<rich:column width="50px">
						<f:facet name="header">
							<h:outputText value="Excluir" />
						</f:facet>
						<a4j:commandLink action="#{servidorController.excluirIntencao}"
							reRender="form" ajaxSingle="true">
							<h:graphicImage value="../images/delete.gif" style="border:0"
								id="delete" />

						</a4j:commandLink>
						<rich:toolTip for="editar" value="Editar" />
					</rich:column>


				</rich:dataTable>
		
		
		
				<rich:dataTable value="#{meuPrimeiroDataTable.resultado}" var="item">
				
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="PROCESSO" />
					
					</f:facet>
					
					<h:outputText value="#{item.id}" />
					
					</rich:column>
					
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="DATA DA INTENÇÃO" />
					
					</f:facet>
					
					<h:outputText value="#{item.id}" />
					
					</rich:column>									
					
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="CAMPUS ORIGEM" />
					
					</f:facet>
					
					<h:outputText value="#{item.email}" />
					
					</rich:column>
					
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="CAMPUS DESTINO" />
					
					</f:facet>
					
					<h:outputText value="#{item.email}" />
					
					</rich:column>
					
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="ESTADO" />
					
					</f:facet>
					
					<h:outputText value="#{item.email}" />
					
					</rich:column>
					
					<rich:column>
					
					<f:facet name="header">
					
					<h:outputText value="CLASSIFICACAO" />
					
					</f:facet>
					
					<h:outputText value="#{item.email}" />
					
					</rich:column>
					
						<rich:column>
					
					<f:facet name="header">
					
					
					</f:facet>
					
					<h:outputText value="#{item.email}" />
					
					</rich:column>
				
				</rich:dataTable>
		<br/><br/>	
		
		
		
		
		
		
    
				
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>
			
		</a4j:form>
	</rich:panel>	
	</f:view>
</body>
</html>