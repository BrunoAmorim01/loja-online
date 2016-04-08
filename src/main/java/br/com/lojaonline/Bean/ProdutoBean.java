package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.CategoriaDAO;
import br.com.lojaonline.Service.ProdutoService;
import br.com.lojaonline.model.Categoria;
import br.com.lojaonline.model.Produto;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	@Inject
	private ProdutoService produtoService;

	@Inject
	CategoriaDAO categoriaDAO;

	private Produto produto;

	private List<Produto> produtos;
	private List<Categoria> categorias;

	@PostConstruct
	public void init() {
		produtos = produtoService.getProdutoDAO().list("nome");
	}

	public void novo() {
		produto = new Produto();
		produto.setQuantidadeEstoque(0);
		categorias = categoriaDAO.list("nome");
	}

	public void carregarCategorias() {
		categorias = categoriaDAO.list("nome");
	}

	public void salvar() {
		produtoService.salvar(produto);
		Messages.addGlobalInfo("Produto salvo com sucesso");
		novo();
		init();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
