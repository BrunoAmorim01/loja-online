package br.com.lojaonline.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
public class Estoque extends GenericModel {

	@OneToMany(mappedBy = "estoque", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	//@JoinColumn(name="movimentacao_id",nullable = false, foreignKey = @ForeignKey(name = "FK_movimentacao"))
	private List<EstoqueMovimentacaoEntrada> movimentacao;
	
	@NotNull
	@Column(name = "data_hora", nullable = false)
	private LocalDate dataCompra;
	
	@Column(length=100,nullable=false)
	private String nNotaFiscal;	
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorTotal;
	
	@Column(columnDefinition = "text")
	private String observacoes;

	public List<EstoqueMovimentacaoEntrada> getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(List<EstoqueMovimentacaoEntrada> movimentacao) {
		this.movimentacao = movimentacao;
	}

	public LocalDate getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}

	public String getnNotaFiscal() {
		return nNotaFiscal;
	}

	public void setnNotaFiscal(String nNotaFiscal) {
		this.nNotaFiscal = nNotaFiscal;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	

}
