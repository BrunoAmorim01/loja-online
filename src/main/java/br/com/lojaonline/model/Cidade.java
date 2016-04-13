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
public class Cidade extends GenericModel {

	@NotBlank
	@Column(length = 50, nullable = false)
	private String nome;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "estado_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Estado"))
	private Estado estado;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
