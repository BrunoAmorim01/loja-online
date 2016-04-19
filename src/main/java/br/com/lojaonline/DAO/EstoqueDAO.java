package br.com.lojaonline.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.lojaonline.DAO.filter.EstoqueMovimentacaoEntradaFilter;
import br.com.lojaonline.model.Estoque;

@RequestScoped
public class EstoqueDAO extends GenericDAO<Estoque> {

	public List<Estoque> pesquisar(EstoqueMovimentacaoEntradaFilter filter){
		
		return null;
		
	}
}
