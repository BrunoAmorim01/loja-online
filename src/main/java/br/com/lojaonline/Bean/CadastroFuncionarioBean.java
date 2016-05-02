package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.GrupoDAO;
import br.com.lojaonline.Service.FuncionarioService;
import br.com.lojaonline.model.Funcionario;
import br.com.lojaonline.model.Grupo;
import br.com.lojaonline.model.Pessoa;
import br.com.lojaonline.model.Usuario;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CadastroFuncionarioBean implements Serializable {

	@Inject
	private FuncionarioService funcionarioService;

	private Funcionario funcionario;



	@Inject
	private GrupoDAO grupoDAO;

	private List<Grupo> grupos;

	// @PostConstruct
	public void init() {
		grupos = grupoDAO.list();

		if (funcionario == null) {
			System.out.println("novo");
			novo();
		}
	}

	public void novo() {
		funcionario = new Funcionario();
		funcionario.setPessoa(new Pessoa());
		funcionario.getPessoa().setUsuario(new Usuario());
	}

	public void salvar() {

		funcionario = funcionarioService.salvar(funcionario);

		Messages.addGlobalInfo("Funcionaro salvo com sucesso");

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}	

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

}
