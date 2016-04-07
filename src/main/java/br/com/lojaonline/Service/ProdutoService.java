package br.com.lojaonline.Service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.ProdutoDAO;
import br.com.lojaonline.model.Produto;

@RequestScoped
public class ProdutoService {

	@Inject
	private ProdutoDAO produtoDAO;

	@Transactional
	public Produto salvar(Produto produto) {

		return produtoDAO.merge(produto);
	}

	public ProdutoDAO getProdutoDAO() {
		return produtoDAO;
	}
}
