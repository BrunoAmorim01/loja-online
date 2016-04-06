package br.com.lojaonline.DAO;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;

import br.com.lojaonline.model.Categoria;

@RequestScoped
@Transactional
public class CategoriaDAO extends GenericDAO<Categoria> {

	
}
