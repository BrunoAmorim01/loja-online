package br.com.lojaonline.Service;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.hibernate.procedure.ProcedureCall;

import br.com.lojaonline.DAO.ProdutoDAO;
import br.com.lojaonline.DAO.filter.ProdutoFilter;
import br.com.lojaonline.model.Produto;

@RequestScoped
public class ProdutoService {

	@Inject
	private ProdutoDAO produtoDAO;

	@Transactional
	public Produto salvar(Produto produto) {
		if (produto.getDataCadastro() == null) {
			produto.setDataCadastro(LocalDate.now());
		}
		return produtoDAO.merge(produto);
	}

	@Transactional
	public void excluir(Produto produto) {
		produtoDAO.remove(produto);
	}

	public List<Produto> pesquisar(ProdutoFilter filter) {
		return produtoDAO.filtrados(filter);

	}

}
