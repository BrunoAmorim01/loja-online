package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.DAO.FabricanteDAO;
import br.com.lojaonline.model.Fabricante;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class FabricanteBean implements Serializable {

	@Inject
	private FabricanteDAO fabricanteDAO;
	
	private Fabricante fabricante;
	
	List<Fabricante> fabricantes;
	
	public void init(){
		
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
}
