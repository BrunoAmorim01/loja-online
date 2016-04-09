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
public class Endereco extends GenericModel {	

	@NotBlank
	@Column(length=10,nullable=false)
	private String tipo;
	
	@NotBlank
	@Column(length=150,nullable=false)
	private String logradouro;
	
	@NotBlank
	@Column(length=8,nullable=false)
	private Integer cep;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="bairro_id",nullable=false,foreignKey=@ForeignKey(name="FK_Bairro"))
	private Bairro bairro;
}
