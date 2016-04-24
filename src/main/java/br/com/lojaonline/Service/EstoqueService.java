package br.com.lojaonline.Service;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.EstoqueDAO;
import br.com.lojaonline.model.Estoque;

@RequestScoped
public class EstoqueService {

	@Inject
	private EstoqueDAO estoqueDAO;

	@Transactional
	public Estoque salvar(Estoque estoque) {

		if (!estoque.getMovimentacao().isEmpty()) {

			Estoque result = estoqueDAO.merge(estoque);

			if (estoque.getCodigo() == null) {
				estoqueDAO.AdicionarEstoque(result);
			}

			return result;
		} else {
			Messages.addGlobalError("A lista de produtos está vazia");
			return null;
		}

	}

	public Estoque findId(long codigo) {
		return estoqueDAO.porIdEager(codigo);
	}
}
