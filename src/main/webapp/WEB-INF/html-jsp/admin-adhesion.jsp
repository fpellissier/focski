<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>Admin Adhesion</title>
</head>

<body background="img/standard.jpg">
<div style="text-align: center; font-weight: bold;"><big>Administration
des adh�rents et des adh�sions au Foc Ski Club.<br>
</big></div>
		<p align="lelf">
		<button type="button" onClick='location.href="accueil.htm";'>Retour</button></p>
<br>
<table border="1" cellpadding="1" cellspacing="2">
	<tbody>
		<tr>
			<td style="text-align: center;">Cr�e un adh�rent<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Page de cr�ation d'un adh�rent"
				ONCLICK="window.location.href='adCreateAdherent.htm'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">G�rer toutes les adh�sions<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir toutes les adh�sions"
				ONCLICK="window.location.href='showAllAdherents.htm'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">G�rer les adh�sions Comp�tition<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adh�sions en comp�tition"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=competition'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">G�rer les adh�sions Loisir du Mercredi<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adh�sions loisir du Mercredi"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=loisirM'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">G�rer les adh�sions Loisir du Samedi<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adh�sions loisir du Samedi"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=loisirS'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">G�rer les adh�sions b�n�voles<br>
			</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Voir les adh�sions des b�n�voles"
				ONCLICK="window.location.href='showAllAdherents.htm?filtre=benevole'"></FORM>
			</td>
		</tr>
		<tr>
			<td style="text-align: center;">T�l�charger une extraction
			compl�te de la base</td>
			<td>
			<FORM><INPUT TYPE="BUTTON"
				VALUE="Extraction Excel de toutes les adh�sions"
				ONCLICK="window.location.href='excelExtract.htm'"></FORM></td>
		</tr>
	</tbody>
</table>
</html>