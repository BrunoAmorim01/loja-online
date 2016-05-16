package br.com.lojaonline.model;

import java.beans.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import br.com.lojaonline.model.enumerable.FormaPagamento;
import br.com.lojaonline.model.enumerable.StatusPedido;

@SuppressWarnings("serial")
@Entity
public class Pedido extends GenericModel {

	public Pedido() {

	}

	@Column(name = "data_criacao", nullable = false)
	private LocalDateTime dataCriacao;

	@Column(columnDefinition = "text")
	private String observacao;

	@NotNull
	@Column(name = "data_entrega", nullable = false)
	private LocalDate dataEntrega;

	@NotNull
	@Column(name = "valor_frete", precision = 10, scale = 2)
	private BigDecimal valorFrete;

	@NotNull
	@Column(name = "valor_desconto", precision = 10, scale = 2)
	private BigDecimal valorDesconto;

	@NotNull
	@Column(name = "valor_total", precision = 10, scale = 2)
	private BigDecimal valorTotal;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 21)
	private StatusPedido status = StatusPedido.ORCAMENTO;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "forma_pagamento", nullable = false, length = 20)
	private FormaPagamento formaPagamento;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	List<ItemPedido> itens;

	@NotNull
	@ManyToOne
	@JoinColumn(nullable = false)
	Funcionario funcionario;

	@ManyToOne
	@JoinColumn(nullable = false)
	Cliente cliente;

	public void addItemPedido(Produto produto) {
		ItemPedido item = new ItemPedido();
		item.setMovimentacao(new Movimentacao());
		item.getMovimentacao().setProduto(produto);
		item.getMovimentacao().setQuantidade(new Short("1"));
		item.getMovimentacao().setValorUnitario(produto.getValorUnitario());

		item.setValorEstoque(BigDecimal.valueOf(16.32));
		item.setPedido(this);

		itens.add(item);
	}

	@Transient
	public BigDecimal getSubtotal() {

		BigDecimal total = itens.stream().map(i -> i.getMovimentacao().getValorParcial()).reduce(BigDecimal.ZERO,
				BigDecimal::add);

		return total;

	}

	public void calcularValorTotal() {
		BigDecimal total = itens.stream().map(i -> i.getMovimentacao().getValorParcial()).reduce(BigDecimal.ZERO,
				BigDecimal::add);
		// valorTotal.add(getSubtotal().subtract(valorFrete.subtract(valorDesconto)));

		valorTotal = total.add(valorFrete.subtract(valorDesconto));
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public LocalDate getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
