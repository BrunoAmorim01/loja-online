package br.com.lojaonline.model;

public enum MovimentacaoEnum {

	ENTRADA("Entrada"), SAIDA("Saída"),DEVOLUCAO("Devolução");

	private String descricao;

	private MovimentacaoEnum(String descricao) {
		this.descricao =descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
