<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Admin Adhesion</title>
</head>

<body background="img/standard.jpg">
<div style="text-align: center; font-weight: bold;"><big>Administration
des adhérents et des adhésions au Foc Ski Club.<br>
</big></div>
		<p align="lelf">
		<button type="button" onClick='location.href="accueil.htm";'>Retour</button></p>
<br>
<table border="1" cellpadding="1" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align: center;">Crée un adhérent<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Page de création d'un adhérent"
				ONCLICK="window.location.href='adCreateAdherent.htm'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Gérer toutes les adhésions<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir toutes les adhésions"
				ONCLICK="window.location.href='showAllAdherents.htm'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Gérer les adhésions Compétition<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adhésions en compétition"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=competition'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Gérer les adhésions Loisir du Mercredi<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adhésions loisir du Mercredi"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=loisirM'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Gérer les adhésions Loisir du Samedi<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adhésions loisir du Samedi"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=loisirS'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Gérer les adhésions bénévoles<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adhésions des bénévoles"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=benevole'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">Télécharger une extraction
			complète de la base</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Extraction Excel de toutes les adhésions"
				ONCLICK="window.location.href='excelExtract.htm'"></FORM></td>
		</tr>
	</tbody>
</table>
</html>