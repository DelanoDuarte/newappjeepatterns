package br.com.appjee.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.UserBusiness;
import br.com.appjee.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private UserBusiness userBusiness;

	public LoginServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		User user = new User();
		user.setLogin("user");
		user.setSenha("1234");
		userBusiness.salvar(user);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/pages/login/login.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		User user = (User) userBusiness.findUserByLogin(request.getParameter("login"));
		if (user != null) {
			if (user.getSenha().equals(request.getParameter("senha"))) {
				Cookie cookie;
				cookie = new Cookie("TOKEN", request.getRequestedSessionId());
				response.addCookie(cookie);

				request.getRequestDispatcher("/pages/home/home.jsp").forward(request, response);
			}
		} else {
			doGet(request, response);
		}
	}

}
