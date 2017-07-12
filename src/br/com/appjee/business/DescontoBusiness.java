/**
 * 
 */
package br.com.appjee.business;

import java.io.Serializable;
import java.util.List;

import br.com.appjee.domain.Desconto;

/**
 * @author Delano Jr
 *
 */
public interface DescontoBusiness extends Serializable {

	public Desconto salvar(Desconto desconto);

	public List<Desconto> buscarTodos();

	public Desconto buscaPorId(Long id);
}
