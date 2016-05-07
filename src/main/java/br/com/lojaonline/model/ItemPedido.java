package br.com.lojaonline.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "item_pedido")
public class ItemPedido extends GenericModel {

	@Embedded
	private Movimentacao movimentacao;

	@NotNull
	@Column(name = "valor_estoque", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorEstoque;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Pedido pedido;

	public BigDecimal getPrecoParcial() {
		return movimentacao.getProduto().getValorUnitario().multiply(new BigDecimal(movimentacao.getQuantidade() + ""));
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public BigDecimal getValorEstoque() {
		return valorEstoque;
	}

	public void setValorEstoque(BigDecimal valorEstoque) {
		this.valorEstoque = valorEstoque;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
