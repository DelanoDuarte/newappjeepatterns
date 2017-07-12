package br.com.apjee.securityfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class InterceptingFilter
 */
@WebFilter(filterName = "InterceptingFilter", urlPatterns = { "/*", "/pages/*" })
public class InterceptingFilter implements Filter {

	private final String TOKEN = "TOKEN";
	private final String loginPath = "/login";
	// private final String logoutPath = "/logout";
	private boolean userLogado;

	public InterceptingFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		// String path = req.getServletPath();

		userLogado = (checkToken(req) && validaToken(req, req.getRequestedSessionId())) ? true : false;

		if (userLogado) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(loginPath);
			requestDispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	private boolean checkToken(HttpServletRequest req) {
		boolean hasToken = false;
		if (req.getCookies() != null) {
			for (Cookie c : req.getCookies()) {
				hasToken = c.getName().equals(TOKEN) ? true : false;
				System.out.println("nome " + c.getName() + ", valor: " + c.getValue());
				if (hasToken)
					break;
			}
		}
		return hasToken;
	}

	private boolean validaToken(HttpServletRequest req, String valor) {
		boolean tokenOk = false;

		for (Cookie c : req.getCookies()) {
			if (c.getName().equals(TOKEN)) {
				tokenOk = c.getValue().equals(req.getRequestedSessionId()) ? true : false;
				break;
			}
		}
		return tokenOk;
	}

}
