/**
 * 
 */
package br.com.appjee.business;

import java.io.Serializable;
import java.util.List;

import br.com.appjee.domain.Funcionario;

/**
 * @author Delano Jr
 *
 */
public interface FuncionarioBusiness extends Serializable {

	public Funcionario salvar(Funcionario funcionario);

	public List<Funcionario> buscarTodos();

	public Funcionario buscarPorId(Long id);

	public void excluir(Funcionario funcionario);

	public Double calcularValorTotalGratificacoes(Funcionario funcionario);

	public Double calcularValorTotalDescontos(Funcionario funcionario);
}
