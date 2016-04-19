package br.com.lojaonline.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Embeddable
public class Movimentacao {

	@NotNull(message = "é obrigatório")
	@Min(1)
	@Max(value = 9999, message = "tem um valor muito alto")
	@Column(nullable = false, length = 4)
	private Short quantidade;

	@NotNull
	@Column(name = "valor_unitario", nullable = false, precision = 10, scale = 2)
	private BigDecimal valorUnitario;
	
	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_produto"))
	private Produto produto;
}
