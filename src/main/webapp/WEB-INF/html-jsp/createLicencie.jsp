<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html;charset=ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {
	color: red;
}
</style>
</head>
<body background="img/standard.jpg">

<!-- Menu de navigation du site -->
<h1>Cr&eacute;ation d'une nouvelle adh&eacute;sion</h1>
<p align="left">
<button type="button" onClick='location.href="accueil.htm";'>Retour</button>
</p>

<form:form method="post" commandName="formBean">
	<table border="1" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Pr&eacute;nom du licencié:</td>
			<td><form:input path="prenom" size="25" maxlength="50" /></td>
			<td><form:errors path="prenom" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Nom du licencié:</td>
			<td><form:input path="nom" size="25" maxlength="50" /></td>
			<td><form:errors path="nom" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Date de naissance (JJ/MM/AAAA) :</td>
			<td><form:input path="naissance" size="25" maxlength="50" /></td>
			<td><form:errors path="naissance" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Sexe :</td>
			<td><form:select path="sexe">
				<form:option value="garcon" label="garcon" />
				<form:option value="fille" label="fille" />
			</form:select></td>
			<td><form:errors path="sexe" cssClass="error" /></td>
		</tr>
	</table>
	<br></br>
	<hr style="width: 100%; height: 2px;">

	<p align="left">Choisissez le type d'adhésion : <form:select
		path="licenceType">
		<form:option value="**********" label="Choisissez!"></form:option>
		<form:options items="${adhesions}"></form:options>
	</form:select></p>

	<p align="left">Selectionner le niveau de ski : <form:select
		path="niveau">
		<form:option value="**********" label="Aucun"></form:option>
		<form:options items="${niveaux}"></form:options>
	</form:select></p>

	<p align="left">Quelle(s) sortie(s) vous intéresse ? <form:select
		path="seances">
		<form:option value="**********" label="Aucune"></form:option>
		<form:options items="${seances}"></form:options>
	</form:select></p>
	<p align="left">Choisissez l'arret de bus : <form:select
		path="arretBus">
		<form:option value="**********" label="Aucun"></form:option>
		<form:options items="${arretbus}"></form:options>
	</form:select> <br>
	<br>
	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Enregistrez cette adhésion</td>
			<td><input type="submit" class="Bouton" value="Je valide"></td>
			<td><input type="reset" class="Bouton" value="Annuler"></td>
		</tr>
	</table>
</form:form>

</body>
</html>

