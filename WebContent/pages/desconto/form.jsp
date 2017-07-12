<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Novo Desconto">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	<%@ include file="/WEB-INF/tags/menu.jsp"%>	
	
  <div class="container">

		<div class="col-md-12">
			<div class="page-header">
				<div align="center">
					<h2>Novo Desconto</h2>
				</div>
			</div>
		</div>
	
	
	<div class="col-md-12">
		
	<div class="panel panel-primary">
		<div class="panel-heading">Novo Desconto</div>
			 <div class="panel-body">
			 
		<form action="${pageContext.request.contextPath}/Desconto/new"
							method="post">
			<div class="form-group">
				<label for="nome">Nome do Desconto:</label> <input type="text"
									class="form-control" id="nome" name="nome">
			</div>
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="number"
									class="form-control" id="valor" name="valor">
			</div>
			<button type="submit" class="btn btn-success">Salvar</button>
		</form>
		
			</div>
		</div>	
	
	</div>
	</div>

</jsp:attribute>

</t:layout>