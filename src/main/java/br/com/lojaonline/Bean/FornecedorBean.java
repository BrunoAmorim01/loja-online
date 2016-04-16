package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.BairroDAO;
import br.com.lojaonline.DAO.EstadoDAO;
import br.com.lojaonline.DAO.FornecedorDAO;
import br.com.lojaonline.Service.FornecedorService;
import br.com.lojaonline.model.Bairro;
import br.com.lojaonline.model.Cidade;
import br.com.lojaonline.model.Estado;
import br.com.lojaonline.model.Fornecedor;
import br.com.lojaonline.model.Pessoa;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class FornecedorBean implements Serializable {

	private Fornecedor fornecedor;

	@Inject
	private FornecedorDAO fornecedorDAO;

	@Inject
	private FornecedorService fornecedorService;

	private List<Fornecedor> fornecedores;

	@PostConstruct
	public void init() {		
		fornecedor = new Fornecedor();
		fornecedor.setPessoa(new Pessoa());
		fornecedores = fornecedorDAO.list();
	}

	public void novo() {
		fornecedor = new Fornecedor();
		fornecedor.setPessoa(new Pessoa());
	}

	public void salvar() {		
		fornecedor = fornecedorService.salvar(fornecedor);
		Messages.addGlobalInfo("Fornecedor " + fornecedor.getPessoa().getNome() + " cadastrado com sucesso");
		fornecedores = fornecedorDAO.list();

	}
	@Transactional
	public void carregarFornecedor(ActionEvent event){
		
		Fornecedor fornecedorSelecionado=  (Fornecedor) event.getComponent().getAttributes().get("fornecedorSelecionado");				
		fornecedor=fornecedorDAO.porID(fornecedorSelecionado.getCodigo());		
	}

	public void excluir(ActionEvent event) {

	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

}
