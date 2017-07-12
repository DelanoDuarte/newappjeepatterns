/**
 * 
 */
package br.com.appjee.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Delano Jr
 *
 */
@Entity
@Table(name = "tb_funcinario")
@NamedQueries(@NamedQuery(name = "Funcionario.findAll", query = "select f from Funcionario f"))
public class Funcionario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long id;

	@Column
	private String nome;

	@Column
	private String sobrenome;

	@Column
	private String cpf;

	@Column
	private Double salario;

	@Column
	private Double salarioGratificacoesDescontos;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dataContratacao;

	@Column
	private boolean ativo;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_gratificacoes_funcionario", joinColumns = @JoinColumn(name = "id_funcionario"), inverseJoinColumns = @JoinColumn(name = "id_gratificacao"))
	private List<Gratificacao> gratificacoes;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tb_descontos_funcionario", joinColumns = @JoinColumn(name = "id_funcionario"), inverseJoinColumns = @JoinColumn(name = "id_desconto"))
	private List<Desconto> descontos;

	public Funcionario() {
	}

	public Funcionario(String nome, String sobrenome, String cpf, Double salario, Date dataNascimento,
			List<Gratificacao> gratificacoes, List<Desconto> descontos) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.salario = salario;
		this.dataNascimento = dataNascimento;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ativo ? 1231 : 1237);
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataContratacao == null) ? 0 : dataContratacao.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((descontos == null) ? 0 : descontos.hashCode());
		result = prime * result + ((gratificacoes == null) ? 0 : gratificacoes.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result
				+ ((salarioGratificacoesDescontos == null) ? 0 : salarioGratificacoesDescontos.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (ativo != other.ativo)
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataContratacao == null) {
			if (other.dataContratacao != null)
				return false;
		} else if (!dataContratacao.equals(other.dataContratacao))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (descontos == null) {
			if (other.descontos != null)
				return false;
		} else if (!descontos.equals(other.descontos))
			return false;
		if (gratificacoes == null) {
			if (other.gratificacoes != null)
				return false;
		} else if (!gratificacoes.equals(other.gratificacoes))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (salarioGratificacoesDescontos == null) {
			if (other.salarioGratificacoesDescontos != null)
				return false;
		} else if (!salarioGratificacoesDescontos.equals(other.salarioGratificacoesDescontos))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", salario="
				+ salario + ", salarioGratificacoesDescontos=" + salarioGratificacoesDescontos + ", dataNascimento="
				+ dataNascimento + ", dataContratacao=" + dataContratacao + ", ativo=" + ativo + ", gratificacoes="
				+ gratificacoes + ", descontos=" + descontos + "]";
	}

}
