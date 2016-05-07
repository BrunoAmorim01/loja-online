package br.com.lojaonline.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.FuncionarioDAO;
import br.com.lojaonline.model.Funcionario;

@RequestScoped
public class FuncionarioService {

	@Inject
	private FuncionarioDAO funcionarioDAO;	
	
	@Transactional
	public Funcionario salvar(Funcionario funcionario) {
		
		if(funcionario.getPessoa().getDataHoraCadastro() ==null)
		funcionario.getPessoa().setDataHoraCadastro(LocalDateTime.now());
		
		return funcionarioDAO.merge(funcionario);

	}

	public List<Funcionario> pesquisar() {

		return funcionarioDAO.list();

	}
}
