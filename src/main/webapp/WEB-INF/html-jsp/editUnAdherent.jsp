<%@ page language="java" pageEncoding="ISO-8859-15" contentType="text/html;charset=ISO-8859-15"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page isELIgnored="false"%>

<html>
<head>
<title>Focski modification adhérent</title>
</head>
<body background="img/standard.jpg">
<h2>Modification des données adhérent</h2>

<spring:bind path="adherent">
	<c:if test="${status.error}">
		<h3>Les erreurs suivantes se sont produites :</h3>
		<ul>
			<c:forEach items="${status.errorMessages}" var="erreur">
				<li><c:out value="${erreur}" /></li>
			</c:forEach>
		</ul>
		<hr>
	</c:if>
</spring:bind>

<p align="left">
<button type="button" onClick='location.href="accueil.htm";'>Retour</button>
</p>

<form method="post" action="<c:url value="/editUnAdherent.htm"/>"
	name="formBean">

<table border="0">
	<tr>
		<td>Votre pseudo de connexion est: </td>
		<td><c:out value="${adherent.dataUser.login}" /></td>
	</tr>
</table>

<hr>

<table border="1">
	<tr>
		<td></td>
		<td>Contact Principal (Tuteur)</td>
		<td></td>
		<td>Contact Secondaire</td>
	</tr>
	<tr>
		<td>Nom</td>
		<spring:bind path="adherent.nom">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.nom2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Prénom</td>
		<spring:bind path="adherent.prenom">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.prenom2">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Couriel</td>
		<spring:bind path="adherent.eMail1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.eMail2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Téléphone maison</td>
		<spring:bind path="adherent.telFix1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.telFix2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Téléphone bureau</td>
		<spring:bind path="adherent.telBur1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.telBur2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Téléphone mobile</td>
		<spring:bind path="adherent.telMob1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.telMob2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Adresse (rue)</td>
		<spring:bind path="adherent.rue1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.rue2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Adresse (CP)</td>
		<spring:bind path="adherent.cp1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.cp2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Adresse (Ville)</td>
		<spring:bind path="adherent.ville1">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
		<spring:bind path="adherent.ville2">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="30"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
</table>

<p>Le contact secondaire est : <spring:bind
	path="adherent.contactSecondaireEst">
	<c:choose>
		<c:when test="${status.value=='pere'}">
			<input type="radio" name="${status.expression}" value="pere" checked>P&egrave;re
									<input type="radio" name="${status.expression}" value="mere">M&egrave;re
									<input type="radio" name="${status.expression}" value="autre">Autre...
							</c:when>
		<c:when test="${status.value=='mere'}">
			<input type="radio" name="${status.expression}" value="pere">P&egrave;re
								<input type="radio" name="${status.expression}" value="mere"
				checked>M&egrave;re
								<input type="radio" name="${status.expression}" value="autre">Autre...
							</c:when>
		<c:otherwise>
			<input type="radio" name="${status.expression}" value="pere">P&egrave;re
								<input type="radio" name="${status.expression}" value="mere">M&egrave;re
								<input type="radio" name="${status.expression}" value="autre"
				checked>Autre...
							</c:otherwise>
	</c:choose>
</spring:bind></p>
<hr>
<p>Vous pouvez saisir un commentaire, une précision :</p>
<spring:bind path="adherent.commentaire">
	<td><textarea name=<c:out value="${status.expression}"/>
		id="commentaire" style="width: 800px;" rows="2"><c:out
		value='${status.value}' escapeXml='false' /></TEXTAREA></td>
</spring:bind> <br>
<input type="hidden" value="${adherent.dataUser.login}" name="username">
<input type="submit" value="Valider"></form>
</body>
</html>
