<%@ include file="/WEB-INF/html-jsp/include.jsp" %>
<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Pre-Inscription en ligne au Ski Club de Froges</title>
</head>
<body>
<h1 align="center">Froges Olympique Club - pré-inscriptions</h1>
<h2 align="center">Saison 2011-2012</h2>
<br><br>
<p><c:out value="${model.text}"/>
</p>
<br>
<p align="center">
<button type="button" onClick='location.href="login.jsp";'>Retour au login</button>
</p>
</body>
</html>