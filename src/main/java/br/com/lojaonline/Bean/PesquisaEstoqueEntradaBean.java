package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.DAO.EstoqueDAO;
import br.com.lojaonline.DAO.filter.EstoqueMovimentacaoEntradaFilter;
import br.com.lojaonline.model.Estoque;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaEstoqueEntradaBean implements Serializable {

	private Estoque estoque;
	private EstoqueMovimentacaoEntradaFilter filter;

	private List<Estoque> estoques;

	@Inject
	private EstoqueDAO estoqueDAO;

	@PostConstruct
	public void init() {
		estoques = estoqueDAO.list();
		filter = new EstoqueMovimentacaoEntradaFilter();
	}

	public void pesquisar() {
		estoques = estoqueDAO.pesquisar(filter);
	}

	public void excluir(ActionEvent event) {

	}

	public EstoqueMovimentacaoEntradaFilter getEntradaFilter() {
		return filter;
	}

	public void setEntradaFilter(EstoqueMovimentacaoEntradaFilter entradaFilter) {
		this.filter = entradaFilter;
	}

	public Estoque getEstoque() {
		return estoque;
	}

	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}

	public List<Estoque> getEstoques() {
		return estoques;
	}

	public void setEstoques(List<Estoque> estoques) {
		this.estoques = estoques;
	}

}
