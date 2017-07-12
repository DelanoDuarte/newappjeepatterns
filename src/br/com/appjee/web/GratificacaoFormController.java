package br.com.appjee.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.GratificacaoBusiness;
import br.com.appjee.domain.Gratificacao;

/**
 * Servlet implementation class GratificacaoFormController
 */
@WebServlet("/Gratificacao/new")
public class GratificacaoFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private GratificacaoBusiness gratificacaoBusiness;

	private Gratificacao gratificacao;

	public GratificacaoFormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/pages/gratificacao/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String valor = request.getParameter("valor");

		boolean result = salvarGratificacao(nome, valor);

		if (result)
			request.setAttribute("msg", "Nova Gratificação Cadastrada com Sucesso !");

		request.getRequestDispatcher("/pages/gratificacao/list.jsp").forward(request, response);
	}

	private boolean salvarGratificacao(String nome, String valor) {

		try {

			Double valorToSave = Double.valueOf(valor);

			gratificacao = new Gratificacao(nome, valorToSave);

			gratificacaoBusiness.salvar(gratificacao);

			if (gratificacao != null)
				return true;

		} catch (Exception e) {

		}

		return false;
	}

}
