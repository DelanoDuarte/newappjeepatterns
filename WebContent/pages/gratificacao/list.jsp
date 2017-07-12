<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Gratifica��es Cadastradas">

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
					<h2>Gratifica��es Cadastradas</h2>
				</div>
			</div>
		</div>
	
	<div class="col-md-12">
		
		<div class="panel panel-primary">
		<div class="panel-heading">Gratifica��es Cadastradas</div>
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
					<c:forEach items="${gratificacoes}" var="gratificacao">
						<tr>
							<td>${gratificacao.nome}</td>
							<td>R$ ${gratificacao.valor}</td>
						</tr>
				
					</c:forEach>
				</tbody>
	
			
		</table>
		
		</div>
		</div>
		
		</div>
		<br />
		<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/Gratificacao/new">Nova Gratifica��o</a>
		
	</div>
</jsp:attribute>

</t:layout>