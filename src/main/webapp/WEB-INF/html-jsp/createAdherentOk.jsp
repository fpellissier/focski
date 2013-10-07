<%@ page language="java" pageEncoding="ISO-8859-15" contentType="text/html;charset=ISO-8859-15"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body>
<h1 align="center">Récapitulation des données de votre compte</h1>
<br>
<br>
<p>Merci de bien mémoriser vos données de connexion ci-dessous :</p>
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td>Notez votre username pour la connexion :</td>
		<td><b><span style="color: rgb(204, 0, 0);"><c:out
			value="${model.adherent.dataUser.login}" /></span></b></td>
	</tr>
	<tr>
		<td>Notez votre mot de passe :</td>
		<td><b><span style="color: rgb(204, 0, 0);"><c:out
			value="${model.adherent.dataUser.passwd}" /></span></b></td>
	</tr>
</table>
<p>Il est conseillé de changer ce mot de passe par defaut lors de votre premiere connexion</p>


<button type="button" onClick='location.href="accueil.htm";'>Accès au service d'inscription</button>

<hr>
<p>Ci dessous un récapitulatif des données enregistrées. Vous pouvez modifier ces valeurs une fois connecté.</p>

<p>Contact principal.</p>
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td>Votre prénom :</td>
		<td><c:out value="${model.adherent.prenom}" /></td>
	</tr>
	<tr>
		<td>Votre nom :</td>
		<td><c:out value="${model.adherent.nom}" /></td>
	</tr>
	<tr>
		<td>Votre adresse eMail :</td>
		<td><c:out value="${model.adherent.eMail1}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone maison :</td>
		<td><c:out value="${model.adherent.telFix1}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone fixe bureau :</td>
		<td><c:out value="${model.adherent.telBur1}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone mobile :</td>
		<td><c:out value="${model.adherent.telMob1}" /></td>
	</tr>
	<tr>
		<td>Adresse (rue cidex...) :</td>
		<td><c:out value="${model.adherent.rue1}" /> <c:out
			value="${model.adherent.cp1}" /> <c:out
			value="${model.adherent.ville1}" /></td>
	</tr>
</table>

<p>Contact secondaire.</p>
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td>Prénom :</td>
		<td><c:out value="${model.adherent.prenom2}" /></td>
	</tr>
	<tr>
		<td>Nom :</td>
		<td><c:out value="${model.adherent.nom2}" /></td>
	</tr>
	<tr>
		<td>Votre adresse eMail2 :</td>
		<td><c:out value="${model.adherent.eMail2}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone fixe maison :</td>
		<td><c:out value="${model.adherent.telFix2}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone mobile :</td>
		<td><c:out value="${model.adherent.telMob2}" /></td>
	</tr>
	<tr>
		<td>Numéro de téléphone fixe bureau :</td>
		<td><c:out value="${model.adherent.telBur2}" /></td>
	</tr>
	<tr>
		<td>Adresse (rue cidex...) :</td>
		<td><c:out value="${model.adherent.rue2}" /> <c:out
			value="${model.adherent.cp2}" /> <c:out
			value="${model.adherent.ville2}" /></td>
	</tr>
</table>

</body>
</html>
