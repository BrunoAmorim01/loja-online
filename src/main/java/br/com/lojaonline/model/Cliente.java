package br.com.lojaonline.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.lojaonline.model.enumerable.TipoPessoa;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericModel {

	@Column(name = "doc_receita_federal", nullable = false, length = 14)
	private long documentoReceitaFederal;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 10)
	private TipoPessoa tipo;

	@OneToOne
	@JoinColumn(name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(name = "FK_Pessoa_Cliente"))
	private Pessoa pessoa;

	public long getDocumentoReceitaFederal() {
		return documentoReceitaFederal;
	}

	public void setDocumentoReceitaFederal(long documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
