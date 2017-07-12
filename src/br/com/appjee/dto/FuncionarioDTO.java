/**
 * 
 */
package br.com.appjee.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import br.com.appjee.domain.Desconto;
import br.com.appjee.domain.Gratificacao;

/**
 * @author delano.duarte
 *
 */
public class FuncionarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String nome;

	private String sobrenome;

	private String cpf;

	private Double salario;

	private Double salarioGratificacoesDescontos;

	private Date dataNascimento;

	private Date dataContratacao;

	private boolean ativo;

	private List<Gratificacao> gratificacoes;

	private List<Desconto> descontos;

	public FuncionarioDTO() {

	}

	public FuncionarioDTO(String nome, String sobrenome, String cpf, Double salario,
			Double salarioGratificacoesDescontos, Date dataNascimento, Date dataContratacao, boolean ativo,
			List<Gratificacao> gratificacoes, List<Desconto> descontos) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.salario = salario;
		this.salarioGratificacoesDescontos = salarioGratificacoesDescontos;
		this.dataNascimento = dataNascimento;
		this.dataContratacao = dataContratacao;
		this.ativo = ativo;
		this.gratificacoes = gratificacoes;
		this.descontos = descontos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getSalarioGratificacoesDescontos() {
		return salarioGratificacoesDescontos;
	}

	public void setSalarioGratificacoesDescontos(Double salarioGratificacoesDescontos) {
		this.salarioGratificacoesDescontos = salarioGratificacoesDescontos;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public List<Gratificacao> getGratificacoes() {
		return gratificacoes;
	}

	public void setGratificacoes(List<Gratificacao> gratificacoes) {
		this.gratificacoes = gratificacoes;
	}

	public List<Desconto> getDescontos() {
		return descontos;
	}

	public void setDescontos(List<Desconto> descontos) {
		this.descontos = descontos;
	}

}
