package br.com.lojaonline.DAO;

import java.util.List;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.lojaonline.model.Cliente;

@RequestScoped
public class ClienteDAO extends GenericDAO<Cliente> {

	public List<Cliente> filtrados() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cliente> porNome(String nome) {

		final String consulta = "select c from Cliente c Join c.pessoa p where LOWER(p.nome) LIKE :nome";
		TypedQuery<Cliente> query = manager.createQuery(consulta, Cliente.class);
		query.setParameter("nome", "%" + nome + "%");

		return query.getResultList();

	}

}
