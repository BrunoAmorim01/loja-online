package br.com.lojaonline.model;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class Bairro extends GenericModel {

	private Cidade cidade;
	
	@Column(length=50,nullable=false)
	private String nome;
}
