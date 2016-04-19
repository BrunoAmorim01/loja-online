package br.com.lojaonline.DAO.filter;

import java.time.LocalDate;

public class EstoqueMovimentacaoEntradaFilter {

	private String notaFiscal;
	private LocalDate dataDe;
	private LocalDate dataAte;
	private String produtoNome;
	
	public String getNotaFiscal() {
		return notaFiscal;
	}
	public void setNotaFiscal(String notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
	public LocalDate getDataDe() {
		return dataDe;
	}
	public void setDataDe(LocalDate dataDe) {
		this.dataDe = dataDe;
	}
	public LocalDate getDataAte() {
		return dataAte;
	}
	public void setDataAte(LocalDate dataAte) {
		this.dataAte = dataAte;
	}
	public String getProdutoNome() {
		return produtoNome;
	}
	public void setProdutoNome(String produtoNome) {
		this.produtoNome = produtoNome;
	}
	
}
