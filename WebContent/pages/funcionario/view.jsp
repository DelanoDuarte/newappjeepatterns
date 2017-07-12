<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<t:layout title="Visualizando Funcionário">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	<%@ include file="/WEB-INF/tags/menu.jsp"%>	
	
  <div class="container">

		<div class="col-md-12">
			<div class="page-header">
				<div align="center">
					<h2>Visualizando Funcionário</h2>
				</div>
			</div>
		</div>
		
		<div class="col-md-12">
		
			 <div class="panel panel-primary">
				<div class="panel-heading">Visualizando Funcionário</div>
					 <div class="panel-body">
					 
			<div class="form-group">
				<label for="nome">Nome do Funcionário:</label> 
				<input type="text" class="form-control" id="nome" name="nome"
								readonly="readonly" value="${funcionario.nome}">
			</div>
			<div class="form-group">
				<label for="sobrenome">Sobrenome:</label> 
				<input type="text" class="form-control" id="sobrenome"
								name="sobrenome" readonly="readonly"
								value="${funcionario.sobrenome}">
			</div>
			<div class="form-group">
				<label for="cpf">CPF:</label> 
				<input type="text" class="form-control" id="cpf" name="cpf"
								readonly="readonly" value="${funcionario.cpf}">
			</div>
			<div class="form-group">
				<label for="dataNascimento">Data de Nascimento:</label> 
				<input type="date" class="form-control" id="dataNascimento"
								name="dataNascimento" readonly="readonly"
								value="${funcionario.dataNascimento}">
			</div>
			
			<br />
			
			<div class="col-md-10">
				
				<div class="row">
					<div class="col-md-5">
						<div class="form-group">
							<h4> <label for="salario">Salário:</label> </h4>
										<h4>
											<fmt:formatNumber value="${funcionario.salario}"
												currencySymbol="R$" type="currency" pattern="R$ #,###.##" />
										</h4>				
						</div>
					</div>
					
					<div class="col-md-5">
						<div class="form-group">
							<h4> <label for="salarioCalculado">Salário Calculado:</label> </h4> 
										<h4>
											<fmt:formatNumber
												value="${funcionario.salarioGratificacoesDescontos}"
												currencySymbol="R$" type="currency" pattern="R$ #,###.##" />
										</h4>
						</div>
					</div>
				</div>
			</div>
			
			<br />
			
			</div>
		</div>
		
		<div class="panel panel-primary">
				<div class="panel-heading">Gratificações</div>
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
					<c:forEach items="${funcionario.gratificacoes}" var="gratificacao">
						<tr>
							<td>${gratificacao.nome}</td>
							<td>R$ ${gratificacao.valor}</td>
						</tr>
					</c:forEach>
				</tbody>
				
					</table>
					
				<div align="right">	
					<h5> <label for="salario">Total de Gratificações:</label> </h5>
						<h5>
							<fmt:formatNumber value="${custoGratificacoes}"
								currencySymbol="R$" type="currency" pattern="R$ #,###.##" />
						</h5>				
				</div>
					
					</div>
			</div>
			
			<div class="panel panel-primary">
				<div class="panel-heading">Descontos</div>
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
					<c:forEach items="${funcionario.descontos}" var="desconto">
						<tr>
							<td>${desconto.nome}</td>
							<td>R$ ${desconto.valor}</td>
						</tr>
				
					</c:forEach>
				</tbody>
					</table>
					
				<div align="right">	
					<h5> <label for="salario">Total de Descontos:</label> </h5>
						<h5>
							<fmt:formatNumber value="${custoDescontos}"
								currencySymbol="R$" type="currency" pattern="R$ #,###.##" />
						</h5>				
				</div>
					
					</div>
			</div>
		
			<a class="btn btn-success"
					href="${pageContext.request.contextPath}/Funcionario/list">Voltar</a>			
	
		</div>
		
</div>		
</jsp:attribute>

</t:layout>