package br.com.lojaonline.Service;

import java.time.LocalDateTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.FornecedorDAO;
import br.com.lojaonline.DAO.PessoaDAO;
import br.com.lojaonline.model.Fornecedor;
import br.com.lojaonline.model.Pessoa;
import br.com.lojaonline.util.ConversaoUtil;

@RequestScoped
public class FornecedorService {

	@Inject
	private PessoaDAO pessoaDAO;
	@Inject
	private FornecedorDAO fornecedorDAO;

	@Transactional
	public Fornecedor salvar(Fornecedor fornecedor) {
		System.out.println("service");
		
		if (fornecedor.getPessoa().getDataHoraCadastro() == null) {
			fornecedor.getPessoa().setDataHoraCadastro(LocalDateTime.now());
		}
		
		Pessoa pessoa= pessoaDAO.merge(fornecedor.getPessoa());
		fornecedor.setPessoa(pessoa);		
		return fornecedorDAO.merge(fornecedor);
	}	 
}
