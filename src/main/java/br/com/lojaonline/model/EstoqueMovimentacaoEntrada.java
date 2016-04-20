package br.com.lojaonline.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="estoque_movimentacao_entrada")
public class EstoqueMovimentacaoEntrada extends GenericModel {
	
	@Embedded
	private Movimentacao movimentacao;
	
	@ManyToOne
	@JoinColumn(name="estoque_id",nullable = false, foreignKey = @ForeignKey(name = "FK_estoque"))
	private Estoque estoque;

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	
	
}
