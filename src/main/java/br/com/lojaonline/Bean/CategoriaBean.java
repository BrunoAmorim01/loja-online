package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.TransactionScoped;
import javax.transaction.Transactional;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.CategoriaDAO;
import br.com.lojaonline.model.Categoria;

@SuppressWarnings("serial")
@Named
@ViewScoped

public class CategoriaBean implements Serializable {

	private Categoria categoria;
	
	private List<Categoria> categorias;

	@Inject
	private CategoriaDAO categoriaDAO;

	@PostConstruct
	public void init() {
		categoria = new Categoria();
		categorias = categoriaDAO.list("nome");
	}

	public void novo() {
		categoria = new Categoria();
		
	}

	@Transactional
	public void salvar() {
		categoriaDAO.merge(categoria);
		categoria = new Categoria();
		categorias = categoriaDAO.list("nome");
		Messages.addGlobalInfo("Categoria salva com sucesso");
	}

	@Transactional
	public void excluir(ActionEvent event) {
		categoria =(Categoria) event.getComponent().getAttributes().get("catSelecionada");
		categoriaDAO.remove(categoria);
		categorias = categoriaDAO.list("nome");
		Messages.addGlobalInfo("Categoria excluída com sucesso");
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
