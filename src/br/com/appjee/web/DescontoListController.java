package br.com.appjee.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.DescontoBusiness;
import br.com.appjee.domain.Desconto;

/**
 * Servlet implementation class DescontoListController
 */
@WebServlet("/Desconto/list")
public class DescontoListController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private DescontoBusiness descontoBusiness;

	public DescontoListController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg = (String) request.getAttribute("msg");

		List<Desconto> descontos = descontoBusiness.buscarTodos();

		request.setAttribute("descontos", descontos);
		request.setAttribute("msg", msg);

		request.getRequestDispatcher("/pages/desconto/list.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
