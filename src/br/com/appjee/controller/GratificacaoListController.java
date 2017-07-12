package br.com.appjee.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.GratificacaoBusiness;
import br.com.appjee.domain.Gratificacao;

/**
 * Servlet implementation class GratificacaoListController
 */
@WebServlet("/Gratificacao/list")
public class GratificacaoListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private GratificacaoBusiness gratificacaoBusiness;

	public GratificacaoListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Gratificacao> gratificacaos = gratificacaoBusiness.buscarTodas();

		request.setAttribute("gratificacoes", gratificacaos);

		request.getRequestDispatcher("/pages/gratificacao/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
