<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pre-Inscription en ligne au Ski Club de Froges</title>
</head>
<body onload="document.f.j_username.focus();">
<h1 align="center">Bienvenue au Froges Olympique Club pour la pré-inscriptions</h1>

<p>Je n'ai pas de compte, je souhaiterais en créer un !<button type="button" onClick='location.href="createAdherent.htm";'>Créer
un compte</button>
</p>
<form name='f1' action='searchAdherentByEmail.htm' method='GET'>
<p>J'ai oublié mes identifiants. Mon adresse mail est : <input
	type="text" name="email" value="" size="30" maxlength="100" /> <input
	type="submit" value="Rechercher" /></p>
</form>

<hr>

<p>Pour accéder à votre espace, vous devez vous identifier.</p>

<form name='f2' action='j_spring_security_check' method='POST'>
<table align="center" border="1" cellpadding="3" cellspacing="1">
	<tr>
		<td align="right">Quel est votre identifiant :</td>
		<td><input type="text" name="j_username" value="" size="25"
			maxlength="25" /></td>
	</tr>
	<tr>
		<td align="right">Saisissez votre mot de passe :</td>
		<td><input type="password" " name="j_password" size="25"
			maxlength="25" /></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" value="Ok" /></td>
		<td align="center"><input type="reset" value="Annuler" /></td>
	</tr>
</table>
</form>

</body>
</html>