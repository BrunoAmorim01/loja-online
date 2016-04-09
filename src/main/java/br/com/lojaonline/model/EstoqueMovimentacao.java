package br.com.lojaonline.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
//@Entity
public class EstoqueMovimentacao extends GenericModel {

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_produto"))
	private Produto produto;

	@NotNull(message = "é obrigatório")
	@Min(1)
	@Max(value = 9999, message = "tem um valor muito alto")
	private Short quantidade;
	
	@NotNull
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitarioCompra;

	
}
