package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.filter.EstoqueMovimentacaoEntradaFilter;
import br.com.lojaonline.model.Estoque;
import br.com.lojaonline.model.EstoqueMovimentacaoEntrada;

@RequestScoped
public class EstoqueDAO extends GenericDAO<Estoque> {

	public List<Estoque> pesquisar(EstoqueMovimentacaoEntradaFilter filter) {

		return null;

	}

	public Estoque porIdEager(Long codigo) {
		String consulta = "select e from Estoque e join fetch e.movimentacao m	where e.codigo = :codigo";

		TypedQuery<Estoque> query = manager.createQuery(consulta, Estoque.class);
		query.setParameter("codigo", codigo);

		Estoque resultado = null;

		try {
			resultado = query.getSingleResult();
		} catch (NoResultException e) {
			Messages.addGlobalError("Não foi possivel encontrar o estoque (codigo não existente)");
		}

		return resultado;
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
