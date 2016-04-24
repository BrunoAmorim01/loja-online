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

import br.com.lojaonline.DAO.ProdutoDAO;
import br.com.lojaonline.Service.EstoqueService;
import br.com.lojaonline.model.Estoque;
import br.com.lojaonline.model.EstoqueMovimentacaoEntrada;
import br.com.lojaonline.model.Movimentacao;
import br.com.lojaonline.model.Produto;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CadastroEstoqueEntradaBean implements Serializable {

	private Long codigo;
	private Estoque estoque;
	private EstoqueMovimentacaoEntrada estoqueEntrada;

	private List<Produto> produtos;

	@Inject
	private EstoqueService estoqueService;

	@Inject
	private ProdutoDAO produtoDAO;

	// @PostConstruct
	public void init() {
		estoque = new Estoque();
		estoque.setMovimentacao(new ArrayList<>());
		estoqueEntrada = new EstoqueMovimentacaoEntrada();
		estoqueEntrada.setMovimentacao(new Movimentacao());
	}

	public void carregarEntrada() {
		if (codigo != null) {
			estoque = estoqueService.findId(codigo);

			if (estoque == null)
				init();
			else {
				estoqueEntrada = new EstoqueMovimentacaoEntrada();
				estoqueEntrada.setMovimentacao(new Movimentacao());
			}
		} else {
			init();
		}

	}

	public void salvar() {
		estoque = estoqueService.salvar(estoque);
		Messages.addGlobalInfo("Estoque salvo com sucesso");
	}

	public List<Produto> completarProduto(String nome) {
		produtos = produtoDAO.porNome(nome);

		return produtos;
	}

	private boolean existeProdutoNaLista() {

		boolean result = estoque.getMovimentacao().stream()
				.filter(p -> estoqueEntrada.getMovimentacao().getProduto().equals(p.getMovimentacao().getProduto()))
				.findFirst().isPresent();

		return result;
	}

	public void addProdutoALista() {

		if (!existeProdutoNaLista()) {
			estoqueEntrada.setEstoque(estoque);
			this.estoque.getMovimentacao().add(estoqueEntrada);

			estoqueEntrada = new EstoqueMovimentacaoEntrada();
			estoqueEntrada.setMovimentacao(new Movimentacao());

			estoque.calcularValorTotal();
			// System.out.println(estoque.getValorTotal());
		} else {
			Messages.addGlobalError("Produto ja existe na lista");
		}

	}

	public void RemoverProdutoLista(ActionEvent event) {
		EstoqueMovimentacaoEntrada entrada = (EstoqueMovimentacaoEntrada) event.getComponent().getAttributes()
				.get("produtoSelecionado");

		EstoqueMovimentacaoEntrada result = estoque.getMovimentacao().stream()
				.filter(e -> e.getMovimentacao().getProduto().equals(entrada.getMovimentacao().getProduto()))
				.findFirst().get();

		estoque.getMovimentacao().remove(result);
		estoque.calcularValorTotal();
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public EstoqueMovimentacaoEntrada getEstoqueEntrada() {

		return estoqueEntrada;
	}

	public void setEstoqueEntrada(EstoqueMovimentacaoEntrada estoqueEntrada) {
		this.estoqueEntrada = estoqueEntrada;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
}
