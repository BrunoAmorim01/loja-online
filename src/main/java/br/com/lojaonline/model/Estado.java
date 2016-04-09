package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Estado extends GenericModel {

	@NotBlank
	@Column(length=2,unique=true,nullable=false)
	private String sigla;
	
	@NotBlank
	@Column(length=20,unique=true,nullable=false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
