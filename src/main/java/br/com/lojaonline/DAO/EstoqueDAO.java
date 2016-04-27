package br.com.lojaonline.DAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.filter.EstoqueMovimentacaoEntradaFilter;
import br.com.lojaonline.model.Estoque;
import br.com.lojaonline.model.EstoqueMovimentacaoEntrada;

@RequestScoped
public class EstoqueDAO extends GenericDAO<Estoque> {

	public List<Estoque> pesquisar(EstoqueMovimentacaoEntradaFilter filter) {

		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Estoque> criteriaQuery = criteriaBuilder.createQuery(Estoque.class);
		Root<Estoque> root = criteriaQuery.from(Estoque.class);

		List<Predicate> condicoes = new ArrayList<>();

		if (filter.getDataDe() != null) {
			
			Path<LocalDate> path = root.get("dataCompra");
			Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(path, filter.getDataDe());
			condicoes.add(predicate);
		}

		if (filter.getDataAte() != null) {
			
			Path<LocalDate> path = root.get("dataCompra");
			Predicate predicate = criteriaBuilder.lessThanOrEqualTo(path, filter.getDataAte());
			condicoes.add(predicate);
		}

		if (filter.getNotaFiscal() != null && !filter.getNotaFiscal().isEmpty()) {
			
			Path<String> path = root.get("nNotaFiscal");
			Predicate predicate = criteriaBuilder.equal(path, filter.getNotaFiscal());
			condicoes.add(predicate);

		}

		if (filter.getProdutoNome() != null && !filter.getProdutoNome().isEmpty()) {
			
			Expression<String> path = root.join("movimentacao").get("movimentacao").get("produto").get("nome");
			Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(path),
					"%" + filter.getProdutoNome().toLowerCase() + "%");
			condicoes.add(predicate);
		}

		Predicate[] condicoesComoArray = condicoes.toArray(new Predicate[condicoes.size()]);

		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);

		criteriaQuery.where(todasCondicoes);
		criteriaQuery.orderBy(criteriaBuilder.desc(root.get("dataCompra")));

		TypedQuery<Estoque> query = manager.createQuery(criteriaQuery);

		return query.getResultList();

		// UaiCriteria<Estoque> criteria =
		// UaiCriteriaFactory.createQueryCriteria(manager, Estoque.class);
		//
		// if (filter.getDataAte() != null) {
		// criteria.andLessOrEqualTo("dataCompra", filter.getDataAte());
		// }
		//
		// if (filter.getDataDe() != null) {
		// criteria.andGreaterOrEqualTo("dataCompra", filter.getDataDe());
		// }
		//
		// return criteria.getResultList();

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
