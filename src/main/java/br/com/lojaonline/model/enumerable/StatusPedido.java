package br.com.lojaonline.model.enumerable;

public enum StatusPedido {

	ORCAMENTO("Orçamento"), ABERTO("Aberto"), AGUADRANDO_PAGAMENTO("Aguardando pagamento"), EMITIDO(
			"Emitido"), SAINDO_ENTREGA("Saindo para entrega"), FINALIZADO("Finalizado"), CANCELADO("Cancelado");

	private String descricao;

	private StatusPedido(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
