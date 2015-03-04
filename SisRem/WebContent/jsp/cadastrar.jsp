<%@page import="javax.faces.context.FacesContext"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Instituto Federal do Paran�</title>
<link rel="StyleSheet" type="text/css" href="../css/messages-style.css"
	media="screen" />
</head>

<body>
	<%
		if (FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("Logado") == null) {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect("index.jsp");
		}
	%>
	<f:view>
		<a4j:loadScript src="../js/script.js" />
		<center>
			<a4j:form id="form">
				<rich:panel>

					<h:panelGrid columns="1">
						<h:outputText value="1- Qual sua carreira? "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta1}"
							required="true" requiredMessage="Pergunta 1 � obrigat�rio!">
							<f:selectItem itemValue="Professor Efetivo (DE, 40h ou 20h)"
								itemLabel="Professor Efetivo (DE, 40h ou 20h)" />
							<f:selectItem itemValue="T�cnico-Administrativo em Educa��o"
								itemLabel="T�cnico-Administrativo em Educa��o" />
							<f:selectItem itemValue="Professor Substituto"
								itemLabel="Professor Substituto" />
							<f:selectItem itemValue="Outro" itemLabel="Outro" />
							<a4j:support event="onchange"
								action="#{enqueteController.habilitaCampus}" ajaxSingle="true"
								reRender="pergunta1Text"></a4j:support>
						</h:selectOneRadio>
						<h:inputText id="pergunta1Text"
							disabled="#{!enqueteController.habilitaPergunta1}"
							value="#{enqueteController.enquete.pergunta1Text}" size="50"
							maxlength="200"></h:inputText>
						<br />


						<h:outputText value="2- Onde voc� trabalha? "
							style="font-weight: bold;" />
						<h:selectOneMenu
							value="#{enqueteController.enquete.pergunta2Text}"
							required="true" requiredMessage="Pergunta 2 � obrigat�rio!">
							<f:selectItem itemLabel="SELECIONE" itemValue="" />
							<f:selectItem itemLabel="Assis Chateaubriand"
								itemValue="Assis Chateaubriand" />
							<f:selectItem itemLabel="Campo Largo" itemValue="Campo Largo" />
							<f:selectItem itemLabel="Cascavel" itemValue="Cascavel" />
							<f:selectItem itemLabel="Curitiba" itemValue="Curitiba" />
							<f:selectItem itemLabel="Dtic" itemValue="Dtic" />
							<f:selectItem itemLabel="EAD" itemValue="EAD" />
							<f:selectItem itemLabel="Foz do Igua�u" itemValue="Foz do Igua�u" />
							<f:selectItem itemLabel="Gabinete" itemValue="Gabinete" />
							<f:selectItem itemLabel="Irati" itemValue="Irati" />
							<f:selectItem itemLabel="Ivaipor�" itemValue="Ivaipor�" />
							<f:selectItem itemLabel="Jacarezinho" itemValue="Jacarezinho" />
							<f:selectItem itemLabel="Londrina" itemValue="Londrina" />
							<f:selectItem itemLabel="Palmas" itemValue="Palmas" />
							<f:selectItem itemLabel="Paranagu�" itemValue="Paranagu�" />
							<f:selectItem itemLabel="Paranava�" itemValue="Paranava�" />
							<f:selectItem itemLabel="Proad" itemValue="Proad" />
							<f:selectItem itemLabel="Proens" itemValue="Proens" />
							<f:selectItem itemLabel="Proep" itemValue="Proens" />
							<f:selectItem itemLabel="Progepe" itemValue="Progepe" />
							<f:selectItem itemLabel="Proplan" itemValue="Proplan" />
							<f:selectItem itemLabel="Tel�maco Borba"
								itemValue="Tel�maco Borba" />
							<f:selectItem itemLabel="Umuarama" itemValue="Umuarama" />
							<f:selectItem itemLabel="Reitoria" itemValue="Reitoria" />
						</h:selectOneMenu>
						<br />

						<h:outputText value="3- Qual o seu grau de forma��o? "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta3}"
							required="true" requiredMessage="Pergunta 3 � obrigat�rio!">
							<f:selectItem itemValue="Ensino M�dio" itemLabel="Ensino M�dio" />
							<f:selectItem itemValue="Gradua��o" itemLabel="Gradua��o" />
							<f:selectItem itemValue="Especializa��o"
								itemLabel="Especializa��o" />
							<f:selectItem itemValue="Mestrado" itemLabel="Mestrado" />
							<f:selectItem itemValue="Doutorado" itemLabel="Doutorado" />
							<f:selectItem itemValue="Outro" itemLabel="Outro" />
							<a4j:support event="onchange"
								action="#{enqueteController.habilitaCampus}" ajaxSingle="true"
								reRender="pergunta3Text"></a4j:support>
						</h:selectOneRadio>
						<h:inputText id="pergunta3Text"
							disabled="#{!enqueteController.habilitaPergunta3}"
							value="#{enqueteController.enquete.pergunta3Text}" size="50"
							maxlength="200"></h:inputText>
						<br />

						<h:outputText style="font-weight: bold;"
							value="4- H� quanto tempo voc� trabalha no IFPR/Escola T�cnica ou em outra institui��o de educa��o profissional?" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta4}"
							required="true" requiredMessage="Pergunta 4 � obrigat�rio!">
							<f:selectItem itemValue="Menos de 1 ano"
								itemLabel="Menos de 1 ano" />
							<f:selectItem itemValue="De 1 ano a 2 anos"
								itemLabel="De 1 ano a 2 anos" />
							<f:selectItem itemValue="De 2 anos a 3 anos"
								itemLabel="De 2 anos a 3 anos" />
							<f:selectItem itemValue="De 3 anos a 5 anos"
								itemLabel="De 3 anos a 5 anos" />
							<f:selectItem itemValue="Mais de 5 anos"
								itemLabel="Mais de 5 anos" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="5- Conhe�o as prioridades, objetivos e metas do IFPR? "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta5}"
							required="true" requiredMessage="Pergunta 5 � obrigat�rio!">
							<f:selectItem itemValue="Sim, totalmente"
								itemLabel="Sim, totalmente" />
							<f:selectItem itemValue="Sim, parcialmente"
								itemLabel="Sim, parcialmente" />
							<f:selectItem itemValue="N�o" itemLabel="N�o" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="6- Na sua opini�o, a gest�o de seu campus/reitoria do IFPR tem sido guiada por valores �ticos? "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta6}"
							required="true" requiredMessage="Pergunta 6 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText value="7- Gosto do trabalho que realizo. "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta7}"
							required="true" requiredMessage="Pergunta 7 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
							<f:selectItem itemValue="Outro" itemLabel="Outro" />
							<a4j:support event="onchange"
								action="#{enqueteController.habilitaCampus}" ajaxSingle="true"
								reRender="pergunta7Text"></a4j:support>
						</h:selectOneRadio>
						<h:inputTextarea id="pergunta7Text"
							disabled="#{!enqueteController.habilitaPergunta7}"
							value="#{enqueteController.enquete.pergunta7Text}" rows="5"
							cols="50"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="8- Tenho liberdade para realizar meu trabalho da forma como considero melhor."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta8}"
							required="true" requiredMessage="Pergunta 8 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="9- Recebo as informa��es necess�rias e no momento certo para o desempenho das minhas fun��es."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta9}"
							required="true" requiredMessage="Pergunta 9 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
							<f:selectItem itemValue="Outro" itemLabel="Outro" />
							<a4j:support event="onchange"
								action="#{enqueteController.habilitaCampus}" ajaxSingle="true"
								reRender="pergunta9Text"></a4j:support>
						</h:selectOneRadio>
						<h:inputTextarea id="pergunta9Text"
							disabled="#{!enqueteController.habilitaPergunta9}"
							value="#{enqueteController.enquete.pergunta9Text}" rows="5"
							cols="50"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="10- Como voc� geralmente recebe as informa��es referentes ao IFPR? "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta10}"
							required="true" requiredMessage="Pergunta 10 � obrigat�rio!">
							<f:selectItem itemValue="Site Institucional"
								itemLabel="Site Institucional" />
							<f:selectItem itemValue="E-mail Institucional"
								itemLabel="E-mail Institucional" />
							<f:selectItem itemValue="Informativo Virtual(via email)"
								itemLabel="Informativo Virtual(via email)" />
							<f:selectItem itemValue="Redes Sociais(Facebook)"
								itemLabel="Redes Sociais(Facebook)" />
							<f:selectItem itemValue="Jornal Impresso"
								itemLabel="Jornal Impresso" />
							<f:selectItem itemValue="Jornal Mural" itemLabel="Jornal Mural" />
							<f:selectItem itemValue="Outro" itemLabel="Outro" />
							<a4j:support event="onchange"
								action="#{enqueteController.habilitaCampus}" ajaxSingle="true"
								reRender="pergunta10Text"></a4j:support>
						</h:selectOneRadio>
						<h:inputTextarea id="pergunta10Text"
							disabled="#{!enqueteController.habilitaPergunta10}"
							value="#{enqueteController.enquete.pergunta10Text}" rows="5"
							cols="50"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="11- Que sugest�es voc� oferece para melhorar a comunica��o interna no IFPR? "
							style="font-weight: bold;" />
						<h:inputTextarea
							value="#{enqueteController.enquete.pergunta11Text}"
							required="true" requiredMessage="Pergunta 11 � obrigat�rio!"
							rows="5" cols="50"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="12- Sinto que meu trabalho � estimulante e motivador."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta12}"
							required="true" requiredMessage="Pergunta 12 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />
						<h:outputText
							value="13- Indique o fator que mais gera insatisfa��o no seu trabalho."
							style="font-weight: bold;" />



						<h:panelGrid columns="2">
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13A}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Falta de conhecimento" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13B}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Ambiente de trabalho ruim" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13C}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Sal�rio" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13D}">
							</h:selectBooleanCheckbox>
							<h:outputText value="O Trabalho que realizo" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13E}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Sobrecarga de trabalho" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13F}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Relacionamento com as chefias" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13G}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Relacionamento com os colegas" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13H}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Falta de autonomia" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13I}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Instala��es inadequadas" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta13J}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Outro" />
						</h:panelGrid>
						<h:inputTextarea id="pergunta13Text"
							value="#{enqueteController.enquete.pergunta13Text}" cols="50"
							rows="5"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="14- Meu superior imediato sabe como motivar a equipe. "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta14}"
							required="true" requiredMessage="Pergunta 14 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="15- Meu superior imediato me informa como est� a execu��o do meu trabalho e sobre meu desempenho. "
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta15}"
							required="true" requiredMessage="Pergunta 15 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="16- Tenho liberdade para expressar opini�es diferentes �s de minha chefia no que diz respeito ao andamento dos trabalhos na minha �rea."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta16}"
							required="true" requiredMessage="Pergunta 16 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="17- O trabalho em equipe � incentivado pelo IFPR?"
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta17}"
							required="true" requiredMessage="Pergunta 17 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="18- Sinto-me a vontade para interagir com meus colegas compartilhando minhas experi�ncias positivas e compartilhando minhas d�vidas."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta18}"
							required="true" requiredMessage="Pergunta 18 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="19- O IFPR oferece oportunidades para o meu crescimento e desenvolvimento profissional."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta19}"
							required="true" requiredMessage="Pergunta 19 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="20- As pessoas competentes s�o as que t�m melhores oportunidades no IFPR."
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta20}"
							required="true" requiredMessage="Pergunta 20 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="21- A gest�o de seu campus / Reitoria tem a cultura democr�tica?"
							style="font-weight: bold;" />
						<h:selectOneRadio value="#{enqueteController.enquete.pergunta21}"
							required="true" requiredMessage="Pergunta 21 � obrigat�rio!">
							<f:selectItem itemValue="Sempre" itemLabel="Sempre" />
							<f:selectItem itemValue="Quase Sempre" itemLabel="Quase Sempre" />
							<f:selectItem itemValue="Raramente" itemLabel="Raramente" />
							<f:selectItem itemValue="Nunca" itemLabel="Nunca" />
						</h:selectOneRadio>
						<br />

						<h:outputText
							value="22- O que voc� acredita que deva melhorar em termos de infraestrutura do c�mpus / Reitoria?"
							style="font-weight: bold;" />
						<h:inputTextarea id="pergunta21Text" required="true"
							requiredMessage="Pergunta 22 � obrigat�rio!"
							value="#{enqueteController.enquete.pergunta22Text}" cols="50"
							rows="5"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />

						<h:outputText
							value="23- Indique a principal raz�o pela qual voc� trabalha no IFPR?"
							style="font-weight: bold;" />
						<h:panelGrid columns="2">
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23A}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Sal�rio" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23B}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Estabilidade no emprego" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23C}">
							</h:selectBooleanCheckbox>
							<h:outputText value="O trabalho que realizo" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23D}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Ambiente de trabalho" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23E}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Autonomia no trabalho" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23F}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Reconhecimento" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23G}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Relacionamento com a chefia" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23H}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Falta de op��o de um outro emprego" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23I}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Trabalhar em uma institui��o reconhecida" />
							<h:selectBooleanCheckbox
								value="#{enqueteController.enquete.pergunta23J}">
							</h:selectBooleanCheckbox>
							<h:outputText value="Outro" />
						</h:panelGrid>
						<h:inputTextarea id="pergunta23Text"
							value="#{enqueteController.enquete.pergunta23Text}" cols="50"
							rows="5"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
						<br />


						<h:outputText
							value="24- Se voc� tivesse total controle sobre o IFPR que altera��es voc� faria?"
							style="font-weight: bold;" />
						<h:inputTextarea id="pergunta24Text" required="true"
							requiredMessage="Pergunta 24 � obrigat�rio!"
							value="#{enqueteController.enquete.pergunta24Text}" cols="50"
							rows="5"></h:inputTextarea>
						<h:outputText value="M�ximo 2000 caracteres." />
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

				</rich:panel>
			</a4j:form>
		</center>
	</f:view>
</body>
</html>