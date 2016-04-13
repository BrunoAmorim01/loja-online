package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.lojaonline.model.Bairro;

@RequestScoped
public class BairroDAO extends GenericDAO<Bairro> {

	public List<Bairro> listaPorCidade(Long codigo) {
		final String consulta = "select b from Bairro b where b.cidade.codigo = :codigo";

		TypedQuery<Bairro> query = manager.createQuery(consulta, Bairro.class);
		query.setParameter("codigo", codigo);

		return query.getResultList();
	}

}
