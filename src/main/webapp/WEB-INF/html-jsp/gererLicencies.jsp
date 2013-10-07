<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!-- %@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%-->

<html>
<head>
<title><fmt:message key="title" /></title>
<script type="text/javascript">
	function confirmation() {
		return confirm("Confirmez-vous la suppression de cette adhésion ?")
	}
</script>
</head>
<body background="img/standard.jpg">
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
<h1>Liste des adhésions</h1>

<p align="left">
<button type="button" onClick='location.href="showAllAdherents.htm";'>Retour</button>
</p>

<p>Cette page vous permet de :</p>
<ul>
	<li>Fixer le niveau de ski observé</li>
	<li>Renseigner le type de forfait</li>
	<li>Fournir le numéro de la licence</li>
	<li>Fournir le numéro de la carte club</li>
	<li>Certificat reçu et valide ?</li>
	<li>Montant de l'adhésion(indicatif)</li>
	<li>Solde (reste à payer)</li>
	<li>Etat de l'adhésion</li>
	<li>Commentaire ou information utile</li>
</ul>
<p>Pour modifier d'autres champs, connectez-vous sur le compte de
l'adhérent</p>
<form method="post" action="<c:url value="/gererLicencies.htm"/>"
	name="formBean">
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td>Nom Prénom :</td>
		<td><c:out value="${licencie.nom}" /> <c:out
			value="${licencie.prenom}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Naissance :</td>
		<td><c:out value="${licencie.naissance}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Formule choisie :</td>
		<td><c:out value="${licencie.licenceType}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Date de création :</td>
		<td><c:out value="${licencie.sDateDeCreation}" /></td>
	</tr>
	<tr>
		<td>Niveau :</td>
		<td><c:out value="${licencie.niveau}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Niveau validé FOC :</td>
		<spring:bind path="licencie.niveauValide">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></td>
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
		<td>Type Forfait :</td>
		<td><form:select path="licencie.forfaitType">
			<form:options items="${lesForfaits}" />
		</form:select></td>
	</tr>
	<tr>
		<td>Arret de bus :</td>
		<td><form:select path="licencie.arretBus">
			<form:options items="${lesArretsDeBus}" />
		</form:select></td>
	</tr>
	<tr>
		<td>Numero de licence (neige ou FFS) :</td>
		<spring:bind path="licencie.numLicence">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></td>
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
		<td>Numéro de carte club :</td>
		<spring:bind path="licencie.numCarteClub">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></td>
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
		<td>Certificat médical :</td>
		<spring:bind path="licencie.certificat">
			<td><c:choose>
				<c:when test="${status.value=='true'}">
					<input type="radio" name="${status.expression}" value="true"
						checked>ok
								<input type="radio" name="${status.expression}" value="false">false
						</c:when>
				<c:otherwise>
					<input type="radio" name="${status.expression}" value="true">ok
								<input type="radio" name="${status.expression}" value="false"
						checked>false
						</c:otherwise>
			</c:choose></td>
		</spring:bind>
		<td></td>
	</tr>
	<tr>
		<td>Montant de l'adhésion :</td>
		<spring:bind path="licencie.montant">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></td>
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
		<td>Sommes reçues :</td>
		<spring:bind path="licencie.solde">
			<td><input type="text" value="<c:out value="${status.value}"/>"
				name="<c:out value="${status.expression}"/>"></td>
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
		<td>Status :</td>
		<td><form:select path="licencie.status">
			<form:options items="${lesEtats}" />
		</form:select></td>
	</tr>
	<tr>
		<td>Commentaire :</td>
		<spring:bind path="licencie.commentaire">
			<td><textarea name=<c:out value="${status.expression}"/>
				id="commentaire" style="width: 400px;" rows="5"><c:out
				value='${status.value}' escapeXml='true' /></TEXTAREA></td>
			<td><c:if test="${status.error}">
                			Error codes:
                			<c:forEach items="${status.errorMessages}"
					var="error">
					<c:out value="${error}" />
				</c:forEach>
			</c:if></td>
		</spring:bind>
	</tr>
</table>
<input type="hidden" value="modif" name="modifOUsupp"> <input
	type="submit" value="Valider"></form>

<hr>

<table>
	<tr>
		<td>Vous pouvez supprimer cette adhésion</td>
		<td>
		<form method="post" action="<c:url value="/gererLicencies.htm"/>"
			name="formBeanSupp" onSubmit="return confirmation()"><input
			type="hidden" value="supp" name="modifOUsupp"> <input
			type="submit" value="Supprimer"></form>
		</td>
	</tr>
</table>

</body>
</html>