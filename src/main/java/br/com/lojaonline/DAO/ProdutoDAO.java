package br.com.lojaonline.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import br.com.lojaonline.DAO.filter.ProdutoFilter;
import br.com.lojaonline.model.Categoria;
import br.com.lojaonline.model.Estoque;
import br.com.lojaonline.model.Fabricante;
import br.com.lojaonline.model.Produto;

@RequestScoped
public class ProdutoDAO extends GenericDAO<Produto> {

	public List<Produto> porNome(String nome) {

		final String consulta = "select p from Produto p where LOWER(p.nome) like :nome";
		TypedQuery<Produto> query = manager.createQuery(consulta, Produto.class);
		query.setParameter("nome", "%" + nome.toLowerCase() + "%");

		return query.getResultList();

	}

	public List<Produto> filtrados(ProdutoFilter filter) {

		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteriaQuery = criteriaBuilder.createQuery(Produto.class);
		Root<Produto> root = criteriaQuery.from(Produto.class);

		List<Predicate> condicoes = new ArrayList<>();

		if (filter.getCategoria() != null) {
			Path<Categoria> path = root.join("categoria");

			Predicate predicate = criteriaBuilder.equal(path, filter.getCategoria());

			condicoes.add(predicate);
		}

		if (filter.getFabricante() != null) {
			Path<Fabricante> path = root.join("fabricante");

			Predicate predicate = criteriaBuilder.equal(path, filter.getFabricante());

			condicoes.add(predicate);
		}

		if (filter.getProduto() != null && !filter.getProduto().isEmpty()) {			
			Path<String> path = root.get("nome");
			Predicate predicate = criteriaBuilder.like(criteriaBuilder.lower(path), "%" + filter.getProduto() + "%");
			condicoes.add(predicate);
		}

		if (filter.getSku() != null && !filter.getSku().isEmpty()) {
			Path<String> path = root.get("sku");
			Predicate predicate = criteriaBuilder.equal(criteriaBuilder.upper(path), filter.getSku());
			condicoes.add(predicate);
		}

		Predicate[] condicoesComoArray = condicoes.toArray(new Predicate[condicoes.size()]);

		Predicate todasCondicoes = criteriaBuilder.and(condicoesComoArray);

		criteriaQuery.where(todasCondicoes);		

		TypedQuery<Produto> query = manager.createQuery(criteriaQuery);

		return query.getResultList();

	}

}
