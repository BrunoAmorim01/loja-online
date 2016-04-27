package br.com.lojaonline.DAO.filter;

import br.com.lojaonline.model.Categoria;
import br.com.lojaonline.model.Fabricante;

public class ProdutoFilter {

	private Categoria categoria;
	private Fabricante fabricante;
	private String produto;
	private String sku;
	

	public Categoria getCategoria() {		
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}	
}
