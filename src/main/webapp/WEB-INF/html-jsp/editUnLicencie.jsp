<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" pageEncoding="ISO-8859-1"
	contentType="text/html;charset=ISO-8859-1"%>
<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%-->
<%@ page isELIgnored="false"%>

<html>
<head>
<title>Focski modification licence</title>
<SCRIPT LANGUAGE="JavaScript">
	function confirmation() {
		return confirm("Confirmez-vous la suppression de ce licencie ?")
	}
</SCRIPT>
</head>
<body background="img/standard.jpg">
<h2>Modification des données d'une adhésion</h2>

<spring:bind path="licencie">
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

<form method="post" action="<c:url value="/editUnLicencie.htm"/>"
	name="formBean">
<table border="1">
	<tr>
		<td>Prénom</td>
		<spring:bind path="licencie.prenom">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>" size="20"></td>
			<td><c:if test="${status.error}">
                			Error codes:
                			<c:forEach items="${status.errorMessages}"
					var="error">
					<c:out value="${error}" />
				</c:forEach>
			</c:if></td>
		</spring:bind>
	</tr>
	<tr>
		<td>Nom</td>
		<spring:bind path="licencie.nom">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="20"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Naissance</td>
		<spring:bind path="licencie.naissance">
			<td><input type="text" value="${status.value}"
				name="${status.expression}" size="20"></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
	<tr>
		<td>Fille ou Garcon ?</td>
		<spring:bind path="licencie.sexe">
			<td><c:choose>
				<c:when test="${status.value=='fille'}">
					<input type="radio" name="${status.expression}" value="fille"
						checked>Fille
									<input type="radio" name="${status.expression}" value="garcon">Garcon
							</c:when>
				<c:otherwise>
					<input type="radio" name="${status.expression}" value="fille">Fille
								<input type="radio" name="${status.expression}" value="garcon"
						checked>Garcon
							</c:otherwise>
			</c:choose></td>
			<td>${status.errorMessage}</td>
		</spring:bind>
	</tr>
</table>
<br>
<p><b>Informations sur vos souhaits concernant le ski :</b></p>
<table border="1">
	<tr>
		<td>Formule de glisse choisie</td>
		<td><form:select path="licencie.licenceType">
			<form:options items="${adhesions}" />
		</form:select></td>
		<td>${status.errorMessage}</td>
	</tr>
	<tr>
		<td>Niveau de ski</td>
		<td><form:select path="licencie.niveau">
			<form:options items="${niveaux}" />
		</form:select></td>
		<td>${status.errorMessage}</td>
	</tr>
	<tr>
		<td>Séance(s) choisie(s)</td>
		<td><form:select path="licencie.seances">
			<form:options items="${seances}" />
		</form:select></td>
		<td>${status.errorMessage}</td>
	</tr>
	<tr>
		<td>Arrêt de bus souhaité</td>
		<td><form:select path="licencie.arretBus">
			<form:options items="${arretbus}" />
		</form:select></td>
		<td>${status.errorMessage}</td>
	</tr>
</table>
<br>
<input type="hidden" value="modif" name="modifOUsupp"> <input
	type="submit" value="Valider les modifications"></form>

<c:choose>
	<c:when test="${licencie.status=='Cree'}">
		<hr><br>
		<table>
			<tr>
				<td>Vous pouvez aussi :</td>
				<td>
				<form method="post" action="<c:url value="/editUnLicencie.htm"/>"
					name="formBeanSupp" onSubmit="return confirmation()"><input
					type="hidden" value="supp" name="modifOUsupp"> <input
					type="submit" value="Supprimer cette adhésion"></form>
				</td>
			</tr>
		</table>
	</c:when>
</c:choose>
</body>
</html>
