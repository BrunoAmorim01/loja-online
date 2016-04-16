package br.com.lojaonline.model;

import java.time.LocalDateTime;

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

	@NotNull
	@Column(name="data_hora_cadastro",nullable=false)
	private LocalDateTime dataHoraCadastro;
	
	@NotBlank
	@Size(max = 150, min = 3)
	@Column(length = 150, unique = true, nullable = false)
	private String nome;
	
	@NotBlank
	@Email
	@Column(length = 200, unique = true, nullable = false)
	private String email;	
		
	@Column(name="tel_fixo",nullable=false,length = 10)
	private Long telfixo;	
	
	@Column(name="tel_celular",nullable=false,length = 11)
	private Long telCelular;
	
	@NotNull
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

	public Long getTelfixo() {
		return telfixo;
	}

	public void setTelfixo(Long telfixo) {
		this.telfixo = telfixo;
	}

	public Long getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(Long telCelular) {
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

	public LocalDateTime getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(LocalDateTime dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}
}
