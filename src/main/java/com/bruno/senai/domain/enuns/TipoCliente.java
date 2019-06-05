package com.bruno.senai.domain.enuns;

public enum TipoCliente {
	// Será nosso estático
	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Juridica");

	// Nossos atributos
	private Integer cod;
	private String descricao;

	// construtor
	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	// gettes

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCliente toEnum (Integer cod) {
		if (cod == null) {
			return null;
		}

		for (TipoCliente x : TipoCliente.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
			throw new IllegalArgumentException("Id Inválido" + cod);

		}
		return null;
		

	}

}
