<%@ include file="/WEB-INF/html-jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body background="img/standard.jpg">
    <h1><fmt:message key="admin.heading.showadherents"/></h1>

	<p align="left">
	<button type="button" onClick='location.href="admin-adhesion.htm";'>Retour</button></p>

    <p>Aujourd'hui, nous sommes le : <c:out value="${model.now}"/></p>

	<table border="1" cellpadding="3" cellspacing="0"> 
		<tr>
			<td><b>id</b></td> <td><b>Compte</b></td>
			<td><b>id</b></td><td><b>adhésion</b></td><td><b>naissance</b></td>
			<td><b>formule ski?</b></td><td><b>niveau</b></td><td><b>séance</b></td>
			<td><b>num licence</b></td><td><b>num carte</b></td><td><b>Certificat</b></td>
			<td><b>Etat</b></td>
		</tr>
	    <c:forEach var="ad" items="${model.adherents}" >
	     <tr>
			 <td style=color:red><c:out value="${ad.id}"/></td>
			 <td style=color:red><a href="<c:url value="/gererAdherents.htm?username=${ad.dataUser.login}"/>"> <c:out value="${ad.nom}"/> <c:out value="${ad.prenom}"/></a></td>
			 <td></td>
			 <td style=color:red><c:out value="${ad.eMail1}"/></td>
			 <td style=color:red>tel=<c:out value="${ad.telFix1}"/></td>
			 <td style=color:red>mob=<c:out value="${ad.telMob1}"/></td>
	     </tr>
	    	<c:forEach var="li" items="${ad.licencies}" >
	     		<tr>
	     			 <td></td><td></td>
				     <td><c:out value="${li.id}"/></td>
			 		 <td><a href="<c:url value="/gererLicencies.htm?idl=${li.id}"/>"><c:out value="${li.nom}"/> <c:out value="${li.prenom}"/></a> </td>
				     <td><c:out value="${li.naissance}"/></td>
				     <td><c:out value="${li.licenceType}"/></td>
				     <td><c:out value="${li.niveau}"/></td>
				     <td><c:out value="${li.seances}"/></td>
				     <td><c:out value="${li.numLicence}"/></td>
				     <td><c:out value="${li.numCarteClub}"/></td>
				     <td><c:out value="${li.certificat}"/></td>
				     <td><c:out value="${li.status}"/></td>
	     		</tr>	    
     		</c:forEach>
     	</c:forEach>

    </table>
	<p align="left">
	<button type="button" onClick='location.href="admin-adhesion.htm";'>Retour</button></p>
  </body>
</html>