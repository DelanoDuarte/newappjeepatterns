<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="../../js/jquery.maskMoney.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Sistema</a>
		</div>
		<ul class="nav navbar-nav">
			<li><a href="${pageContext.request.contextPath}/home">Home</a></li>
			<li><a
				href="${pageContext.request.contextPath}/Funcionario/list">Funcionários</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Gerenciamento<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a
						href="${pageContext.request.contextPath}/Gratificacao/list">Gratificações</a></li>
					<li><a href="${pageContext.request.contextPath}/Desconto/list">Descontos</a></li>
				</ul></li>
		</ul>

		</div>
	</nav>
</body>
</html>