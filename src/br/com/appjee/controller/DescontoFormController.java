package br.com.appjee.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.DescontoBusiness;
import br.com.appjee.domain.Desconto;

/**
 * Servlet implementation class DescontoFormController
 */
@WebServlet("/Desconto/new")
public class DescontoFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private DescontoBusiness descontoBusiness;

	private Desconto desconto;

	public DescontoFormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/pages/desconto/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");

		Double valorToSave = Double.valueOf(valor);

		desconto = new Desconto(nome, valorToSave);

		descontoBusiness.salvar(desconto);
		request.getRequestDispatcher("/pages/desconto/list.jsp").forward(request, response);
	}

}
