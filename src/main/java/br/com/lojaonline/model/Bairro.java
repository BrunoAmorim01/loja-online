package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Bairro extends GenericModel {

	@NotNull
	@ManyToOne
	@JoinColumn(name = "cidade_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Cidade"))
	private Cidade cidade;

	@NotBlank
	@Column(length = 50, nullable = false)
	private String nome;
}
