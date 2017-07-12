<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Home">

	<jsp:attribute name="head_area">
</jsp:attribute>

<jsp:attribute name="body_area">
	
<%@ include file="/WEB-INF/tags/menu.jsp"%>
		
  <div class="container">
  	<div class="jumbotron">
		  <h1>Sistema de Controle de Funcionários</h1>
		  <p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Informações</a>
		</p>
	</div>
  </div>
  
</jsp:attribute>

</t:layout>