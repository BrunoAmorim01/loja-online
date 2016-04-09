package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Pessoa extends GenericModel{

	@NotBlank
	@Size(max = 150, min = 3)
	@Column(length = 150, unique = true, nullable = false)
	private String nome;
	
	@Email
	@Column(length = 200, unique = true, nullable = false)
	private String email;	
	
	
	@Column(name="tel_fixo",nullable=false,length = 10)
	private Integer telfixo;
	
	
	@Column(name="tel_celular",nullable=false,length = 11)
	private Integer telCelular;
	
	@NotNull(message = "é obrigatório")
	@Min(1)
	@Column(name = "quantidade_estoque", nullable = false, length = 6)
	private short numLogradouro;

	@NotNull
	@OneToOne	
	@JoinColumn(name="endereco_id",nullable=false,foreignKey=@ForeignKey( name="FK_Endereco"))
	private Endereco endereco;	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelfixo() {
		return telfixo;
	}

	public void setTelfixo(Integer telfixo) {
		this.telfixo = telfixo;
	}

	public Integer getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(Integer telCelular) {
		this.telCelular = telCelular;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public short getNumLogradouro() {
		return numLogradouro;
	}

	public void setNumLogradouro(short numLogradouro) {
		this.numLogradouro = numLogradouro;
	}
}
