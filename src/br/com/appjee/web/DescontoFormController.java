package br.com.appjee.web;

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

		boolean result = salvarDesconto(nome, valor);

		if (result)
			request.setAttribute("msg", "Novo Desconto Cadastrado com Sucesso !");

		request.getRequestDispatcher("/pages/desconto/list.jsp").forward(request, response);
	}

	private boolean salvarDesconto(String nome, String valor) {

		try {
			Double valorToSave = Double.valueOf(valor);

			desconto = new Desconto(nome, valorToSave);

			descontoBusiness.salvar(desconto);

			if (desconto != null)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
