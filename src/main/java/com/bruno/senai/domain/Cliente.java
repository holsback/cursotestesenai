package com.bruno.senai.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.bruno.senai.domain.enuns.TipoCliente;

@Entity // aviso ao jpa que será uma tabela.
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // anotação avisando que esse atributo será uma id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	// Atributos serão Campos na tabela
	private String nome;
	private String cpfOuCnpj;
	// Será usado no enum
	private Integer tipo;

	// O banco de dados não deixa repetir os dados
	@Column(unique = true)
	private String email;

	@ElementCollection // Cria uma tabela telefone
	@CollectionTable(name = "Telefone")
	private Set<String> telefones = new HashSet<>();

	// Construtor
	public Cliente(Integer idCliente, String nome, String cpfOuCnpj, String email, TipoCliente tipo) {
		/* Atributo busca a class */
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.cpfOuCnpj = cpfOuCnpj;
		this.email = email;
		// Aqui não vai telefone
		// Dentro da class busca o cod
		this.tipo = tipo.getCod();
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCliente == null) ? 0 : idCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (idCliente == null) {
			if (other.idCliente != null)
				return false;
		} else if (!idCliente.equals(other.idCliente))
			return false;
		return true;
	}

	// cascade e para se excluir cliente o endereco seja excluido
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL) // varios enderecos de um cliente
	private List<Endereco> enderecos = new ArrayList<>();

}
