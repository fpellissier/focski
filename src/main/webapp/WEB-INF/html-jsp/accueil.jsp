
<table border="0">
	<tr>
		<td>
		<p>
		<button type="button"
			onClick="location.href='j_spring_security_logout';">Me
		déconnecter</button>
		</p>
		</td>
	</tr>
	<tr>
		<td>
		<table align="left" border="0" cellpadding="5" cellspacing="0">
			<tr>
				<td><img alt="focski" src="img/viglogo.jpg"></td>
				<td>
				<p>Bienvenue <b><c:out value="${model.adherent.prenom}" /> <c:out
					value="${model.adherent.nom}" /></b> <br>
				Nous sommes le : <b><c:out value="${model.now}" /></b> <br />
				<p>Vous pouvez consulter, modifier vos données :
				<button type="button" onClick="location.href='editUnAdherent.htm';">Modifier</button>
				</p>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>

		<hr>
		<p>Ci-dessous les personnes inscrites au sein du club</p>
		<p>Vous pouvez créer une nouvelle licence :
		<button type="button" onClick="location.href='createLicencie.htm';">Créer</button>
		</p>
		<br>
		</td>
	</tr>
</table>
<table align="center" border="1" cellpadding="3" cellspacing="0">
	<c:forEach var="li" items="${model.licencies}">
		<tr>
			<td><c:out value="${li.id}" /></td>
			<c:choose>
				<c:when test="${li.status=='Valide'}">
					<td><c:out value="${li.prenom}" /></td>
				</c:when>
				<c:otherwise>
					<td><a
						href="<c:url value="/editUnLicencie.htm?idl=${li.id}"/>"><c:out
						value="${li.prenom}" /></a></td>
				</c:otherwise>
			</c:choose>
			<td><c:out value="${li.nom}" /></td>
			<td><c:out value="${li.naissance}" /></td>
			<td><c:out value="${li.licenceType}" /></td>
			<td><c:out value="${li.niveau}" /></td>
			<td><c:out value="${li.seances}" /></td>
			<td>N°licence=<c:out value="${li.numLicence}" /></td>
			<td>N°carte=<c:out value="${li.numCarteClub}" /></td>
			<td>Certif? <c:out value="${li.certificat}" /></td>
			<c:choose>
				<c:when test="${li.status=='Valide'}">
					<td><span style="color: rgb(51, 204, 0);">Etat=<c:out
						value="${li.status}" /></span></td>
				</c:when>
				<c:otherwise>
					<td><span style="color: rgb(204, 0, 0);">Etat=<c:out
						value="${li.status}" /></span></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</c:forEach>
</table>
