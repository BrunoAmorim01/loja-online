package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;

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
	
	//private Bairro bairro;
}
