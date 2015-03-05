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
		<center>
			<a4j:loadScript src="../js/script.js" />
		</center>
		<a4j:loadScript src="../js/script.js" />
		<a4j:form id="form">
			<rich:panel>

				<h:outputText
					value="Bem vindo #{usuarioController.usuarioAutenticada.nome}, Último acesso em ..." /><br/><br/>
				 <rich:toolBar>

	            <rich:dropDownMenu>
	                <f:facet name="label"> 
	                    <h:panelGroup>
	                        <h:outputText value="Processos"/>
	                    </h:panelGroup>
	                </f:facet>
	                <rich:menuItem submitMode="ajax" value="Solicitar Remoção"
	                    action="#{ddmenu.doNew}">
	                </rich:menuItem>
	                <rich:menuItem submitMode="ajax" value="Acompanhar Processo"
	                    action="#{ddmenu.doNew}">
	                </rich:menuItem>
	              
	              
	            </rich:dropDownMenu>
	
	            <rich:dropDownMenu>
	
	                <f:facet name="label">
	                    <h:panelGrid cellpadding="0" cellspacing="0" columns="2"
	                        style="vertical-align:middle">
	                        <h:outputText value="Editais" />
	                    </h:panelGrid>
	                </f:facet>
	
	                <rich:menuItem submitMode="ajax" value="Visualizar Editais"
	                    action="#{ddmenu.doNew}">
	                </rich:menuItem>
	
	
	            </rich:dropDownMenu>
	            <rich:toolBarGroup location="right">
	             <rich:dropDownMenu>
	            <f:facet name="label"> 
	                    <h:panelGroup>
	                        <h:outputText value="Sair"/>
	                    </h:panelGroup>
	                </f:facet>
	              <rich:menuItem submitMode="ajax" value="Sair"
	                    action="#{ddmenu.doExit}" />
	                    </rich:dropDownMenu>
	            </rich:toolBarGroup>
	            
	        </rich:toolBar>
		<br/><br/>	
		
		
		
		
		
		
    
				
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>
			</rich:panel>
		</a4j:form>
	</f:view>
</body>
</html>