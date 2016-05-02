package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.DAO.filter.ProdutoFilter;
import br.com.lojaonline.Service.ProdutoService;
import br.com.lojaonline.model.Produto;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaProdutoGlobal implements Serializable{

	@Inject
	private ProdutoService produtoService;

	private String produtoString;

	private List<Produto> produtos;

	private ProdutoFilter produtoFilter;

	public void pesquisar() {
		produtos = produtoService.pesquisar(produtoFilter);
	}

	public String getProdutoString() {
		return produtoString;
	}

	public void setProdutoString(String produtoString) {
		this.produtoString = produtoString;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
