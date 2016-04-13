package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.TypedQuery;

import br.com.lojaonline.model.Endereco;

@RequestScoped
public class EnderecoDAO extends GenericDAO<Endereco> {

	public List<Endereco> listaPorBairro(Long codigoBairro, String logradouro) {

		final String consulta = "SELECT e FROM Endereco e Join e.bairro b WHERE b.codigo = :codigo and LOWER (e.logradouro) LIKE :lograd";
		// 
		// 
		TypedQuery<Endereco> query = manager.createQuery(consulta, Endereco.class);
		 query.setParameter("codigo", codigoBairro);
		 query.setParameter("lograd","%"+ logradouro+"%");
		List<Endereco> resultado = query.getResultList();

		return resultado;
	}

}
