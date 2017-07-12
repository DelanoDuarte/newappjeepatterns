package br.com.appjee.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.FuncionarioBusiness;
import br.com.appjee.domain.Funcionario;

/**
 * Servlet implementation class FuncionarioViewController
 */
@WebServlet("/Funcionario/view")
public class FuncionarioViewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioBusiness funcionarioBusiness;

	private Funcionario funcionario;

	public FuncionarioViewController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String funcionarioId = request.getParameter("funcionarioId");

		funcionario = funcionarioBusiness.buscarPorId(Long.valueOf(funcionarioId));

		Double custoTotalGratificacoes = funcionarioBusiness.calcularValorTotalGratificacoes(funcionario);
		Double custoTotalDescontos = funcionarioBusiness.calcularValorTotalDescontos(funcionario);

		request.setAttribute("funcionario", funcionario);
		request.setAttribute("custoGratificacoes", custoTotalGratificacoes);
		request.setAttribute("custoDescontos", custoTotalDescontos);

		request.getRequestDispatcher("/pages/funcionario/view.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
