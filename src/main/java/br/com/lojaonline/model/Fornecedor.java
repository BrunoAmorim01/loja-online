package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;

@SuppressWarnings("serial")
@Entity
public class Fornecedor extends GenericModel {

	@Column(length = 60, unique = true, nullable = false)
	private String razaoSocial;
	
	@CNPJ
	@Column(length=14,nullable=false)
	private Integer cnpj;	
	
	@Column(length=12)
	private Integer inscricaoEstadual;
	
	@NotNull
	@OneToOne
	@JoinColumn(name="pessoa_id",nullable=false,foreignKey=@ForeignKey(name="FK_pessoa"))
	private Pessoa pessoa;

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}	

	public Integer getCnpj() {
		return cnpj;
	}

	public void setCnpj(Integer cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(Integer inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
