package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.filter.EstoqueMovimentacaoEntradaFilter;
import br.com.lojaonline.model.Estoque;
import br.com.lojaonline.model.EstoqueMovimentacaoEntrada;

@RequestScoped
public class EstoqueDAO extends GenericDAO<Estoque> {

	public List<Estoque> pesquisar(EstoqueMovimentacaoEntradaFilter filter) {

		return null;

	}

	
	public void AdicionarEstoque(Estoque estoque) {

		String update = "update Produto p set p.quantidade = :qtde where p.codigo = :codigo";

		for (EstoqueMovimentacaoEntrada m : estoque.getMovimentacao()) {
			Query query = manager.createQuery(update);
			query.setParameter("qtde",
					(short) (m.getMovimentacao().getQuantidade() + m.getMovimentacao().getProduto().getQuantidade()));
			query.setParameter("codigo", m.getMovimentacao().getProduto().getCodigo());

			query.executeUpdate();
			
		}

	}
}
