<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>

<t:layout title="Login - Sistema SIFU">

	<jsp:attribute name="head_area">
</jsp:attribute>

	<jsp:attribute name="body_area">
	
	 <div class="container">
		
		<div class="row" style="margin-top: 20px">
		
			<div
					class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
			
				<form role="form" action="${pageContext.request.contextPath}/login"
						method="post">
				
					<fieldset>
					
						<h2>Entrar</h2>
						<hr class="colorgraph">
						<div class="form-group">
							<input type="text" name="login" id="login"
									class="form-control input-lg" placeholder="Login">
						</div>
						<div class="form-group">
							<input type="password" name="senha" id="senha"
									class="form-control input-lg" placeholder="Senha">
						</div>
						<hr class="colorgraph">
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6" align="center">
								<input type="submit" class="btn btn-lg btn-success btn-block"
										value="Login">
							</div>
						</div>
						
					</fieldset>
					
				</form>
				
			</div>
			
		</div>
	
		
	</div>
	
	
</jsp:attribute>

</t:layout>