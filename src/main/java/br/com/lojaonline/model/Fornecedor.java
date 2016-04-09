package br.com.lojaonline.model;

import javax.persistence.Column;

import org.hibernate.validator.constraints.br.CNPJ;

public class Fornecedor {

	@Column(length = 60, unique = true, nullable = false)
	private String razaoSocial;

	@Column(length = 60, nullable = false)
	private String nomeFantasia;
	
	@CNPJ
	@Column(length=14,nullable=false)
	private Integer cnpj;
	
	
	@Column(length=12)
	private Integer inscricaoEstadual;

}
