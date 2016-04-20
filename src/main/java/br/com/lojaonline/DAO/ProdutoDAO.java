package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.lojaonline.model.Produto;

@RequestScoped
public class ProdutoDAO extends GenericDAO<Produto> {

	public List<Produto> porNome(String nome) {

		final String consulta = "select p from Produto p where LOWER(p.nome) like :nome";
		TypedQuery<Produto> query = manager.createQuery(consulta, Produto.class);
		query.setParameter("nome", "%" + nome.toLowerCase() + "%");

		return query.getResultList();

	}
}
