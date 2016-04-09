package br.com.lojaonline.model;

import javax.persistence.Column;

public class Estado {

	@Column(length=2,unique=true,nullable=false)
	public String sigla;
	
	@Column(length=20,unique=true,nullable=false)
	public String nome;
}
