<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Descontos Cadastradas">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	<%@ include file="/WEB-INF/tags/menu.jsp"%>	
	
  <div class="container">
	
	<c:if test="${not empty msg}">
		<div class="alert alert-success" role="alert">${msg}</div>
	</c:if>
	
		<div class="col-md-12">
			<div class="page-header">
				<div align="center">
					<h2>Descontos Cadastrados</h2>
				</div>
			</div>
		</div>
	
	<div class="col-md-12">
		
		<div class="panel panel-primary">
		<div class="panel-heading">Descontos Cadastrados</div>
			 <div class="panel-body">
		
		<table class="table table-striped table-bordered" cellspacing="0"
							width="100%">
			
				<thead>
				<tr>
	                <th>Nome</th>
	                <th>Valor</th>
	            </tr>
				</thead>
	
				<tbody>
					<c:forEach items="${descontos}" var="desconto">
				
				<tr>
					<td>${desconto.nome}</td>
					<td>R$ ${desconto.valor}</td>
				</tr>
					</c:forEach>
				</tbody>
	
			
		</table>
		
		</div>
		
		</div>
		
		</div>
		<br />
		<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/Desconto/new">Novo Desconto</a>
		
	</div>
</jsp:attribute>

</t:layout>