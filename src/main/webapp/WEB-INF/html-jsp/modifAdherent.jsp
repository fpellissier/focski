<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<h1>Modification d'un compte adhérent au Froges OC Ski</h1>

<form method="post" action="<c:url value=modif></c:url>">
	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">Votre prénom :</td>
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
			<td align="right">Numéro de téléphone fixe :</td>
			<td><form:input path="telFix1" size="10" maxlength="10" /></td>
			<td><form:errors path="telFix1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Numéro de téléphone
			mobile :</td>
			<td><form:input path="telMob1" size="10" maxlength="10" /></td>
			<td><form:errors path="telMob1" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (rue cidex...) :</td>
			<td><form:input path="rue" size="50" maxlength="70" /></td>
			<td><form:errors path="rue" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (ville) :</td>
			<td><form:input path="ville" size="25" maxlength="30" /></td>
			<td><form:errors path="ville" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Adresse (CP) :</td>
			<td><form:input path="cp" size="5" maxlength="10" /></td>
			<td><form:errors path="cp" cssClass="error" /></td>
		</tr>
	</table>
	<hr style="width: 100%; height: 2px;">
	<p>Vous pouvez renseigner un autre contact si vous le souhaitez</p>
	<form:radiobutton path="contactSecondaireEst" value="pere"
		label="P&egrave;re" />
	<form:radiobutton path="contactSecondaireEst" value="mere"
		label="M&egrave;re" />

	<table border="0" cellpadding="3" cellspacing="0">
		<tr>
			<td align="right">adresse eMail secondaire :</td>
			<td><form:input path="eMail2" size="50" maxlength="70" /></td>
			<td><form:errors path="eMail2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Numéro de téléphone fixe
			:</td>
			<td><form:input path="telFix2" size="10" maxlength="10" /></td>
			<td><form:errors path="telFix2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Numéro de téléphone
			mobile :</td>
			<td><form:input path="telMob2" size="10" maxlength="10" /></td>
			<td><form:errors path="telMob2" cssClass="error" /></td>
		</tr>
		<tr>
			<td align="right">Formulaire:</td>
			<td><input type="submit" class="Bouton" value="Envoyer"></td>
			<td><input type="reset" class="Bouton" value="Annuler"></td>
		</tr>
	</table>
</form>

</body>
</html>