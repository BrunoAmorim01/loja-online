package br.com.lojaonline.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class Estoque extends GenericModel {

	private List<EstoqueMovimentacao> movimentacao;
	
	@Column(length=100,nullable=false)
	private String nNotaFiscal;
	
	@NotNull
	@Column(name = "data_hora", nullable = false)
	private LocalDate dataCompra;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal valorTotal;
	
	@Column(length=200)
	private String observacoes;
	

}
