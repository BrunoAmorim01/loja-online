package br.com.lojaonline.model.enumerable;

public enum TipoPessoa {

	FISICA("Física"), JURIDICA("Juridica");

	private String descricao;

	TipoPessoa(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
