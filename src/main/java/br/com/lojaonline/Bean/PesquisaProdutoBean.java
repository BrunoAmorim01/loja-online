package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.CategoriaDAO;
import br.com.lojaonline.DAO.FabricanteDAO;
import br.com.lojaonline.DAO.filter.ProdutoFilter;
import br.com.lojaonline.Service.ProdutoService;
import br.com.lojaonline.model.Categoria;
import br.com.lojaonline.model.Fabricante;
import br.com.lojaonline.model.Produto;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaProdutoBean implements Serializable {

	@Inject
	private ProdutoService produtoService;

	@Inject
	CategoriaDAO categoriaDAO;

	@Inject
	FabricanteDAO fabricanteDAO;

	private ProdutoFilter produtoFilter;

	private List<Produto> produtos;
	private List<Categoria> categorias;
	private List<Fabricante> fabricantes;

	@PostConstruct
	public void init() {
		produtoFilter = new ProdutoFilter();
		produtos = new ArrayList<>();

		categorias = categoriaDAO.list("nome");
		fabricantes = fabricanteDAO.list("nome");
	}

	public void pesquisar() {
		produtos = produtoService.pesquisar(produtoFilter);
	}
	
	public void excluir(ActionEvent event) {
		Produto produto = (Produto) event.getComponent().getAttributes().get("produtoSelecionado");
		produtoService.excluir(produto);
		
		produtos.remove(produto);
		Messages.addGlobalInfo("Produto " + produto.getNome() + " excluido com sucesso");
		
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

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public ProdutoFilter getProdutoFilter() {
		return produtoFilter;
	}

	public void setProdutoFilter(ProdutoFilter produtoFilter) {
		this.produtoFilter = produtoFilter;
	}

}
