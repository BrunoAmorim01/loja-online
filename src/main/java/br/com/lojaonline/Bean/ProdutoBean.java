package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.CategoriaDAO;
import br.com.lojaonline.DAO.FabricanteDAO;
import br.com.lojaonline.DAO.ProdutoDAO;
import br.com.lojaonline.Service.ProdutoService;
import br.com.lojaonline.model.Categoria;
import br.com.lojaonline.model.Fabricante;
import br.com.lojaonline.model.Produto;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ProdutoBean implements Serializable {

	@Inject
	private ProdutoService produtoService;
	
	@Inject
	private ProdutoDAO produtoDAO;	

	private Produto produto;

	private List<Produto> produtos;

	public void novo() {
		produto = new Produto();
		produto.setQuantidade(Short.parseShort(0+""));
		
	}
	
	public void salvar() {
		produtoService.salvar(produto);
		Messages.addGlobalInfo("Produto salvo com sucesso");
		novo();	
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
	
}
