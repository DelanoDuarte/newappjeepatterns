<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Funcionários Cadastrados">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	<%@ include file="/WEB-INF/tags/menu.jsp"%>	
	
  <div class="container">

		<div class="col-md-12">
			<div class="page-header">
				<div align="center">
					<h2>Funcionários Cadastrados</h2>
				</div>
			</div>
		</div>
	
	<div class="col-md-12">
		
		<div class="panel panel-primary">
		<div class="panel-heading">Funcionários Cadastrados</div>
			 <div class="panel-body">	
		
		
		<table class="table table-striped table-bordered" cellspacing="0"
					width="100%">
			
				<thead>
				<tr>
	                <th>Nome</th>
	                <th>Sobrenome</th>
	                <th>CPF</th>
	                <th></th>
	            </tr>
				</thead>
	
				<tbody>
					<c:forEach items="${funcionarios}" var="funcionario">
				
						<tr>
							<td>${funcionario.nome}</td>
							<td>${funcionario.sobrenome}</td>
							<td>${funcionario.cpf}</td>
							<td>
								<div align="center">
									<a class="btn btn-success"
											href="
												<c:url value="/Funcionario/view">
													<c:param name="funcionarioId" value="${funcionario.id}"/>
												</c:url>
											">Visualizar
									</a>
								</div>
							</td>
						</tr>
					</c:forEach>
				</tbody>
		</table>
		
		</div>
		
		</div>
		
		</div>
		<br />
		<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/Funcionario/new">Novo Funcionário</a>
		
	</div>
</jsp:attribute>

</t:layout>