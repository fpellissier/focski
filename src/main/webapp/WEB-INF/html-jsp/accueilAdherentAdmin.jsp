<%@ include file="/WEB-INF/html-jsp/include.jsp" %>
<%@ page language="java" pageEncoding="ISO-8859-1" contentType="text/html;charset=ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
       "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body background="img/standard.jpg">
    <h1><fmt:message key="adherent.heading.accueil"/></h1>
	    <p align="center"><b>Pour accéder aux outils d'administration : </b> 
	    <button type="button" 
			onClick='location.href="admin-adhesion.htm";'>Administrer</button></p>
	    <hr>
    <br>
	<%@ include file="accueil.jsp" %>
  </body>
</html>