package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.lojaonline.model.Cidade;

@RequestScoped
public class CidadeDAO extends GenericDAO<Cidade> {

	public List<Cidade> listaPorEstado(Long codigo) {
		
		final String consulta="select c from Cidade c where c.estado.codigo = :codigo";
		
		TypedQuery<Cidade> query=manager.createQuery(consulta,Cidade.class);
		query.setParameter("codigo", codigo);
		
		return query.getResultList();
	}

}
