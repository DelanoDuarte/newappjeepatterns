package br.com.appjee.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GratificacaoController
 */
@WebServlet("/Gratificacao/*")
public class GratificacaoController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GratificacaoController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String navParam = request.getParameter("navParam");

		if (navParam.equals("list"))
			request.getRequestDispatcher("/Gratificacao/list").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
