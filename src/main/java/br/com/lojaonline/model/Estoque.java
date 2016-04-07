package br.com.lojaonline.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Estoque extends GenericModel {

	@ManyToOne
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "FK_produto"))
	private Produto produto;
	
	@Column(length=100,nullable=false)
	private String nNotaFiscal;

	@NotNull
	@Column(name = "data_hora", nullable = false)
	private LocalDateTime dataHora;

	@NotNull(message = "é obrigatório")
	@Min(1)
	@Max(value = 9999, message = "tem um valor muito alto")
	private Short quantidade;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private EstoqueEnum tipo;
}
