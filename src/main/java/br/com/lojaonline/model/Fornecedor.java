package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

@SuppressWarnings("serial")
@Entity
public class Fornecedor extends GenericModel {

	@NotBlank
	@Column(length = 60, unique = true, nullable = false)
	private String razaoSocial;	
		
	@Column(length=14,nullable=false,unique=true)
	private Long cnpj;	
	
	@Column(length=20)
	private String inscricaoEstadual;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="pessoa_id",nullable=false,foreignKey=@ForeignKey(name="FK_pessoa_fornecedor"))
	private Pessoa pessoa;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}	

	public Long getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
