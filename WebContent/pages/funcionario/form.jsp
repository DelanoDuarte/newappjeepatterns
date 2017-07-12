<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Nova Gratificação">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	<%@ include file="/WEB-INF/tags/menu.jsp"%>	
	
  <div class="container">

		<div class="col-md-12">
			<div class="page-header">
				<div align="center">
					<h2>Novo Funcionário</h2>
				</div>
			</div>
		</div>
	
	<div class="col-md-12">
		
	 <div class="panel panel-primary">
		<div class="panel-heading">Novo Funcionário</div>
			 <div class="panel-body">
	
		<form action="${pageContext.request.contextPath}/Funcionario/new"
							method="post">
			<div class="form-group">
				<label for="nome">Nome do Funcionário:</label> <input type="text"
									class="form-control" id="nome" name="nome">
			</div>
			<div class="form-group">
				<label for="sobrenome">Sobrenome:</label> <input type="text"
									class="form-control" id="sobrenome" name="sobrenome">
			</div>
			<div class="form-group">
				<label for="cpf">CPF:</label> <input type="text"
									class="form-control" id="cpf" name="cpf">
			</div>
			<div class="form-group">
				<label for="dataNascimento">Data de Nascimento:</label> <input
									type="date" class="form-control" id="dataNascimento"
									name="dataNascimento">
			</div>
			
			<div class="form-group">
				<label for="salario">Salario:</label> <input type="number"
									class="form-control" id="salario" name="salario">
			</div>
			
			
			 <div class="panel panel-primary">
				<div class="panel-heading">Gratificações</div>
			 		<div class="panel-body">
			
			<div class="form-group">
				<label for="gratificacoes">Gratificações:</label>
				<br />
			<select id="gratificacoes" class="form-control" multiple
											title="Selectione as Gratificações do Funcionário" multiple
											data-actions-box="true" name="gratificacao">
					<c:forEach items="${gratificacoes}" var="gratificacao">	
					  <option value="${gratificacao.id}">Nome: ${gratificacao.nome} - Valor:R$ ${gratificacao.valor}</option>
					</c:forEach>
			</select>
			</div>
			
					</div>
			</div>
			
			
			 <div class="panel panel-primary">
				<div class="panel-heading">Descontos</div>
			 		<div class="panel-body">
			
			<div class="form-group">
				<label for="descontos">Descontos:</label>
				<br />
			<select id="descontos" class="form-control" multiple
											title="Selectione os Descontos do Funcionário" multiple
											data-actions-box="true" name="desconto">
					<c:forEach items="${descontos}" var="desconto">	
					  <option value="${desconto.id}">Nome: ${desconto.nome} - Valor:R$ ${desconto.valor}</option>
					 </c:forEach>
			</select>
			</div>
			
					</div>
			</div>
			
			
			<button type="submit" class="btn btn-success">Salvar</button>
		
			</form>
		
			</div>
		</div>
	</div>	

	</div>
	
	
</jsp:attribute>

</t:layout>