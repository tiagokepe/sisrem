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
		<a4j:loadScript src="../js/script.js" />
		
			<a4j:form id="form">
				
					
					
					<h:panelGrid columns="1" style="margin-left:0">
						<h:outputText value="Servidor: #{usuarioLogado.nome}" style="font-weight: bold;" />
						<h:outputText value="Selecine o Edital:"
							style="font-weight: bold;" />
						<h:selectOneMenu value=""
						required="true"
						requiredMessage="Selecione o Edital!">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						</h:selectOneMenu>	
						
						<h:outputText value="Campus Origem:" style="font-weight: bold;" />
						<h:selectOneMenu value=""
						required="true">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						</h:selectOneMenu>	
						
						<h:outputText value="Campus Destino:" style="font-weight: bold;" />
						<h:selectOneMenu value=""
						required="true">
						<f:selectItem itemLabel="SELECIONE" itemValue="" />
						</h:selectOneMenu>	
						
						<h:outputText value="Justificativa: " />
						<h:inputTextarea
						value="" cols="60" rows="3"
						onkeypress="mascara(this, soNumeros);">
						</h:inputTextarea>
										

						<br />

						<a4j:commandButton value="Salvar"
							action="#{enqueteController.salvar}"
							reRender="form" />

						<rich:messages layout="list" errorLabelClass="errorLabel"
							style="top:auto;" infoLabelClass="infoLabel">
							<f:facet name="infoMarker">
								<h:graphicImage value="../images/passed.gif" />
							</f:facet>
							<f:facet name="errorMarker">
								<h:graphicImage value="../images/error.gif" />
							</f:facet>
						</rich:messages>

					</h:panelGrid>
					<center>
						<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
					</center>

				
			</a4j:form>
	</rich:panel>
	</f:view>
</body>
</html>