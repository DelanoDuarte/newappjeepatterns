/**
 * 
 */
package br.com.appjee.businessimpl;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.appjee.business.FuncionarioBusiness;
import br.com.appjee.dao.FuncionarioDAO;
import br.com.appjee.domain.Desconto;
import br.com.appjee.domain.Funcionario;
import br.com.appjee.domain.Gratificacao;

/**
 * @author Delano Jr
 *
 */
@RequestScoped
public class FuncionarioBusinessImpl implements FuncionarioBusiness {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private FuncionarioDAO funcionarioDAO;

	@Override
	public Funcionario salvar(Funcionario funcionario) {

		// Assume que um novo funcionario ja comece ativo
		funcionario.setAtivo(true);

		// Data de contratacao e a data no qual foi inserido os dados no sistema
		funcionario.setDataContratacao(new Date());

		Double salarioFuncionario = funcionario.getSalario();

		for (Gratificacao gratificacao : funcionario.getGratificacoes()) {
			salarioFuncionario += gratificacao.getValor();
		}
		for (Desconto desconto : funcionario.getDescontos()) {
			salarioFuncionario -= desconto.getValor();
		}

		funcionario.setSalarioGratificacoesDescontos(salarioFuncionario);

		return funcionarioDAO.update(funcionario);
	}

	// Metodo para mostrar o valor total que foi descontado do salario do
	// funcionario
	@Override
	public Double calcularValorTotalDescontos(Funcionario funcionario) {

		Double valorTotalDescontosCadastrados = 0.0;

		for (Desconto desconto : funcionario.getDescontos()) {
			valorTotalDescontosCadastrados += desconto.getValor();
		}
		return valorTotalDescontosCadastrados;
	}

	// Metodo para mostrar o valor total que foi acrescentado ao salario do
	// funcionario
	@Override
	public Double calcularValorTotalGratificacoes(Funcionario funcionario) {

		Double valorTotalGratificacoesCadastradas = 0.0;

		for (Gratificacao gratificacao : funcionario.getGratificacoes()) {
			valorTotalGratificacoesCadastradas += gratificacao.getValor();
		}
		return valorTotalGratificacoesCadastradas;
	}

	@Override
	public List<Funcionario> buscarTodos() {
		return funcionarioDAO.findAll();
	}

	@Override
	public Funcionario buscarPorId(Long id) {
		return funcionarioDAO.buscarPorId(id);
	}

	@Override
	public void excluir(Funcionario funcionario) {
		funcionarioDAO.delete(funcionario);
	}

}
