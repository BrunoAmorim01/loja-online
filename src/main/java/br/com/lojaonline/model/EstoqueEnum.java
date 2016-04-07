package br.com.lojaonline.model;

public enum EstoqueEnum {

	ENTRADA("Entrada"), SAIDA("Saída");

	private String descricao;

	private EstoqueEnum(String descricao) {
		this.descricao =descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
