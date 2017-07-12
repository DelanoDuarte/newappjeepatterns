package br.com.appjee.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.appjee.business.DescontoBusiness;
import br.com.appjee.business.FuncionarioBusiness;
import br.com.appjee.business.GratificacaoBusiness;
import br.com.appjee.domain.Desconto;
import br.com.appjee.domain.Funcionario;
import br.com.appjee.domain.Gratificacao;

/**
 * Servlet implementation class FuncionarioFormController
 */
@WebServlet("/Funcionario/new")
public class FuncionarioFormController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioBusiness funcionarioBusiness;

	@Inject
	private GratificacaoBusiness gratificacaoBusiness;

	@Inject
	private DescontoBusiness descontoBusiness;

	private Funcionario funcionario;

	public FuncionarioFormController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Gratificacao> gratificacoes = gratificacaoBusiness.buscarTodas();
		List<Desconto> descontos = descontoBusiness.buscarTodos();

		request.setAttribute("gratificacoes", gratificacoes);
		request.setAttribute("descontos", descontos);

		request.getRequestDispatcher("/pages/funcionario/form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String dataNascimento = request.getParameter("dataNascimento");
		String salario = request.getParameter("salario");
		String[] gratificacoes = request.getParameterValues("gratificacao");
		String[] descontos = request.getParameterValues("desconto");

		boolean result = salvarFuncionario(nome, sobrenome, cpf, dataNascimento, salario, gratificacoes, descontos);

		if (result)
			request.setAttribute("msg", "Novo Funcionario Cadastrado com Sucesso !");

		request.getRequestDispatcher("/pages/funcionario/list.jsp").forward(request, response);
	}

	private boolean salvarFuncionario(String nome, String sobrenome, String cpf, String dataNascimento, String salario,
			String[] gratificacoes, String[] descontos) {

		try {
			List<Gratificacao> gratificacoesToSave = new ArrayList<>();
			List<Desconto> descontosToSave = new ArrayList<>();

			for (int i = 0; i < gratificacoes.length; i++) {
				Gratificacao gratificacao = gratificacaoBusiness.buscaPorId(Long.valueOf(gratificacoes[i]));
				if (gratificacao != null)
					gratificacoesToSave.add(gratificacao);
			}

			for (int i = 0; i < descontos.length; i++) {
				Desconto desconto = descontoBusiness.buscaPorId(Long.valueOf(descontos[i]));

				if (desconto != null)
					descontosToSave.add(desconto);
			}

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dataNascFormatada = formatter.parse(dataNascimento);

			Double salarioToSave = Double.valueOf(salario);

			funcionario = new Funcionario(nome, sobrenome, cpf, salarioToSave, dataNascFormatada, gratificacoesToSave,
					descontosToSave);

			funcionarioBusiness.salvar(funcionario);

			if (funcionario != null)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

}
