package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.DAO.BairroDAO;
import br.com.lojaonline.DAO.EstadoDAO;
import br.com.lojaonline.DAO.FornecedorDAO;
import br.com.lojaonline.model.Bairro;
import br.com.lojaonline.model.Cidade;
import br.com.lojaonline.model.Estado;
import br.com.lojaonline.model.Fornecedor;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class FornecedorBean implements Serializable {
	
	private Fornecedor fornecedor;	
	
	@Inject	private FornecedorDAO fornecedorDAO;	
		
	private List<Fornecedor> fornecedores;
	
	
	@PostConstruct
	public void init(){
		fornecedores=fornecedorDAO.list();
	}
	
	public void novo(){
		
	}
	
	public void salvar (){
		
	}
	
	public void excluir (ActionEvent event){
		
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
