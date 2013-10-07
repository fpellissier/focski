<%@ page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Administration des comptes : creation</title>
<style>
.error {
	color: red;
}
</style>
</head>
<body>

<!-- Menu de navigation du site -->
<h1>Création d'un nouveau compte adhérent au Froges OC Ski</h1>

<p align="left">
<button type="button" onClick='location.href="admin-adhesion.htm";'>Retour</button>
</p>

<p>La création d'un compte adhérent doit être unique par famille.</p>

<form:form method="post" commandName="formBean">
	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Votre pr&eacute;nom :</td>
			<td><form:input path="prenom" size="25" maxlength="50" /></td>
			<td><form:errors path="prenom" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Votre nom :</td>
			<td><form:input path="nom" size="25" maxlength="50" /></td>
			<td><form:errors path="nom" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Votre adresse eMail :</td>
			<td><form:input path="eMail1" size="50" maxlength="70" /></td>
			<td><form:errors path="eMail1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone à la
			maison :</td>
			<td><form:input path="telFix1" size="10" maxlength="10" /></td>
			<td><form:errors path="telFix1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone au
			travail :</td>
			<td><form:input path="telBur1" size="10" maxlength="10" /></td>
			<td><form:errors path="telBur1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone
			mobile :</td>
			<td><form:input path="telMob1" size="10" maxlength="10" /></td>
			<td><form:errors path="telMob1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (rue cidex...) :</td>
			<td><form:input path="rue1" size="50" maxlength="70" /></td>
			<td><form:errors path="rue1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (ville) :</td>
			<td><form:input path="ville1" size="25" maxlength="30" /></td>
			<td><form:errors path="ville1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (CP) :</td>
			<td><form:input path="cp1" size="5" maxlength="10" /></td>
			<td><form:errors path="cp1" cssClass="error" /></td>
		</tr>
	</table>
	<hr style="width: 100%; height: 2px;">
	<p>Vous pouvez renseigner un autre contact si vous le souhaitez</p>
	<form:radiobutton path="contactSecondaireEst" value="pere"
		label="P&egrave;re" />
	<form:radiobutton path="contactSecondaireEst" value="mere"
		label="M&egrave;re" />
	<form:radiobutton path="contactSecondaireEst" value="autre"
		label="Autre..." />

	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Votre pr&eacute;nom :</td>
			<td><form:input path="prenom2" size="25" maxlength="50" /></td>
			<td><form:errors path="prenom2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Votre nom :</td>
			<td><form:input path="nom2" size="25" maxlength="50" /></td>
			<td><form:errors path="nom2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">adresse eMail secondaire :</td>
			<td><form:input path="eMail2" size="50" maxlength="70" /></td>
			<td><form:errors path="eMail2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone à la
			maison :</td>
			<td><form:input path="telFix2" size="10" maxlength="10" /></td>
			<td><form:errors path="telFix2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone au
			travail :</td>
			<td><form:input path="telBur2" size="10" maxlength="10" /></td>
			<td><form:errors path="telBur2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Num&eacute;ro de t&eacute;l&eacute;phone
			mobile :</td>
			<td><form:input path="telMob2" size="10" maxlength="10" /></td>
			<td><form:errors path="telMob2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (rue cidex...) :</td>
			<td><form:input path="rue2" size="50" maxlength="70" /></td>
			<td><form:errors path="rue2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (ville) :</td>
			<td><form:input path="ville2" size="25" maxlength="30" /></td>
			<td><form:errors path="ville2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (CP) :</td>
			<td><form:input path="cp2" size="5" maxlength="10" /></td>
			<td><form:errors path="cp2" cssClass="error" /></td>
		</tr>
	</table>
	<hr style="width: 100%; height: 2px;">
	<p>Vous pouvez apporter des précisions/compléments d'information
	dans cette zone.</p>
	<textarea name="commentaire" style="width: 800px;" rows="4" /></TEXTAREA>

	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Formulaire:</td>
			<td><input type="submit" class="Bouton" value="Valider"></td>
			<td><input type="reset" class="Bouton" value="Effacer"></td>
		</tr>
	</table>
</form:form>

</body>
</html>

