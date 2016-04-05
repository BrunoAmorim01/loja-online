package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Any;
import javax.enterprise.inject.Default;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.DAO.CategoriaDAO;
import br.com.lojaonline.DAO.DAOgeneric;
import br.com.lojaonline.model.Categoria;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CategoriaBean implements Serializable {

	private Categoria categoria;
	private List<Categoria> categorias;

	@Inject
	private CategoriaDAO categoriaDAO;

	public void init() {
		categorias = categoriaDAO.list("nome");
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
