package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.Service.FuncionarioService;
import br.com.lojaonline.model.Funcionario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaFuncionarioBean implements Serializable {

	@Inject
	FuncionarioService funcionarioService;

	private Funcionario funcionario;

	private List<Funcionario> funcionarios;

	@PostConstruct
	public void init() {
		
		setFuncionarios(funcionarioService.pesquisar());
		
	}

	public void pesquisar() {

	}
	
	public void excluir(){
		
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
