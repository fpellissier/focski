<%@ include file="/WEB-INF/html-jsp/include.jsp"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--%@ taglib uri="/WEB-INF/tld/spring.tld" prefix="spring"%-->

<html>
<head>
<title><fmt:message key="title" /></title>
<script type="text/javascript">
	function EpochToHuman(timeStamp) {
		var outputtext = "";
		var datum = new Date(timeStamp);
		outputtext += datum.toLocaleString();
		document.formBean.datecreation.value = outputtext;
	}
	function confirmation() {
		return confirm("Supprimer un adhérent, supprime l'ensemble des adhésions associées. Vous confirmez ?")
	}
</script>
</head>
<body background="img/standard.jpg">
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
<h1>Liste des comptes</h1>

<p align="left">
<button type="button" onClick='location.href="showAllAdherents.htm";'>Retour</button>
</p>

<p>Cette page vous permet de :</p>
<ul>
	<li>créer une licence</li>
	<li>modifier le mot de passe de connexion d'un compte (le username
	n'est pas modifiable)</li>
	<li>bloquer l'accès d'un compte</li>
	<li>changer le rôle</li>
	<li>supprimer un adhérent</li>
</ul>

<p>Vous pouvez créer une nouvelle licence :
<button type="button" onClick='location.href="adCreateLicencie.htm?username=${adherent.dataUser.login}";'>Créer</button>
</p>


<p>Pour modifier d'autres champs, connectez-vous sur le compte de
l'adhérent</p>
<form method="post" action="<c:url value="/gererAdherents.htm"/>"
	name="formBean">
<table border="1" cellpadding="3" cellspacing="0">
	<tr>
		<td>Nom Prénom :</td>
		<td><c:out value="${adherent.nom}" /> <c:out
			value="${adherent.prenom}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Le username :</td>
		<td><c:out value="${adherent.dataUser.login}" /></td>
		<td></td>
	</tr>
	<tr>
		<td>Date de création :</td>
		<td><c:out value="${adherent.sDateDeCreation}" /></td>
	</tr>
	<tr>
		<td>Mot de passe :</td>
		<spring:bind path="adherent.dataUser.passwd">
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
		<td>Le rôle :</td>
		<spring:bind path="adherent.dataUser.role">
			<td><c:choose>
				<c:when test="${status.value=='ROLE_ADHERENT'}">
					<input type="radio" name="${status.expression}"
						value="ROLE_ADHERENT" checked>ADHERENT
								<input type="radio" name="${status.expression}"
						value="ROLE_ADMIN">ADMIN
						</c:when>
				<c:otherwise>
					<input type="radio" name="${status.expression}"
						value="ROLE_ADHERENT">ADHERENT
								<input type="radio" name="${status.expression}"
						value="ROLE_ADMIN" checked>ADMIN
						</c:otherwise>
			</c:choose></td>
		</spring:bind>
		<td></td>
	</tr>
	<tr>
		<td>Etat Actif :</td>
		<spring:bind path="adherent.dataUser.accessEnabled">
			<td><c:choose>
				<c:when test="${status.value=='false'}">
					<input type="radio" name="${status.expression}" value="false"
						checked>false
								<input type="radio" name="${status.expression}" value="true">true
						</c:when>
				<c:otherwise>
					<input type="radio" name="${status.expression}" value="false">false
								<input type="radio" name="${status.expression}" value="true"
						checked>true
						</c:otherwise>
			</c:choose></td>
		</spring:bind>
		<td></td>
	</tr>
</table>

<p>Zone de commentaire :</p>
<spring:bind path="adherent.commentaire">
	<td><textarea name=<c:out value="${status.expression}"/>
		id="commentaire" style="width: 800px;" rows="4"><c:out
		value='${status.value}' escapeXml='false' /></TEXTAREA></td>
</spring:bind> <br>
<input type="hidden" value="modif" name="modifOUsupp"> <input
	type="submit" value="Valider"></form>

<hr>
<table>
	<tr>
		<td>Vous pouvez supprimer cet adhérent (et avec tous ses
		adhésions) :</td>
		<td>
		<form method="post" action="<c:url value="/gererAdherents.htm"/>"
			name="formBeanSupp" onSubmit="return confirmation()"><input
			type="hidden" value="supp" name="modifOUsupp"> <input
			type="submit" value="Supprimer"></form>
		</td>
	</tr>
</table>

</body>
</html>