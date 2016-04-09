package br.com.lojaonline.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@SuppressWarnings("serial")
@Entity
public class Produto extends GenericModel {

	@NotNull
	@Column(name="data_cadastro",nullable=false)
	private LocalDate dataCadastro;
	
	@NotBlank
	@Size(min = 3, max = 80)
	@Column(length = 80, nullable = false, unique = true)
	private String nome;

	@NotBlank
	@Column(nullable = false, length = 20, unique = true)
	private String sku;
	
	@NotNull
	@Column(nullable=false)
	private boolean ativo;
	
	@NotNull(message = "é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	private Short quantidade;
	
	@NotNull(message = "é obrigatório")
	@Min(0)
	@Max(value = 9999, message = "tem um valor muito alto")
	private Short quantidadeMinima;

	@NotNull
	@Column(name="valor_unitario",nullable=false,precision=10,scale=2)
	private BigDecimal valorUnitario;
	
	@Column(length = 20)
	private String dimensoes;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="fabricante_id",nullable=false,foreignKey=@ForeignKey(name="FK_Fabricante"))
	private Fabricante fabricante;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name="categoria_id",nullable=false,foreignKey=@ForeignKey(name="FK_Categoria"))
	private Categoria categoria;
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getDimensoes() {
		return dimensoes;
	}

	public void setDimensoes(String dimensoes) {
		this.dimensoes = dimensoes;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public Short getQuantidadeMinima() {
		return quantidadeMinima;
	}

	public void setQuantidadeMinima(Short quantidadeMinima) {
		this.quantidadeMinima = quantidadeMinima;
	}

}
