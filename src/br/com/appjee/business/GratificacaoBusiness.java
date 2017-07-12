/**
 * 
 */
package br.com.appjee.business;

import java.io.Serializable;
import java.util.List;

import br.com.appjee.domain.Gratificacao;

/**
 * @author Delano Jr
 *
 */
public interface GratificacaoBusiness extends Serializable {

	public Gratificacao salvar(Gratificacao gratificacao);

	public List<Gratificacao> buscarTodas();

	public Gratificacao buscaPorId(Long id);
}
