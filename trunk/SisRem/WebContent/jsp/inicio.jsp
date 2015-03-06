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
			<jsp:directive.include file="menu.jsp" />
		<h:outputText value="Editais vigentes:" styleClass="negrito" /><br/><br/>
		<rich:dataList var="editais" value="Editais" rows="10">
            <h:outputText value="Edital ..."/><br/>
            <h:outputText value="Ano: XXXX" styleClass="negrito"></h:outputText>
            <h:outputText value=" Término: XX/XX/XXXX" styleClass="negrito"></h:outputText>
        </rich:dataList>
    
				
				<center>
					<h:graphicImage value="../images/assinatura.png"></h:graphicImage>
				</center>
		</rich:panel>
		</a4j:form>
	</f:view>
</body>
</html>