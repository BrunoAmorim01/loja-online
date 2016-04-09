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

	@PostConstruct
	public void init() {
		fabricantes = fabricanteDAO.list("nome");
	}

	public void novo() {
		fabricante = new Fabricante();
	}

	@Transactional
	public void salvar() {
		fabricanteDAO.merge(fabricante);
		Messages.addGlobalInfo("Fabricante " + fabricante.getNome() + " salvo com sucesso");
		novo();
		init();
		
	}

	@Transactional
	public void excluir(ActionEvent event) {
		fabricante = (Fabricante) event.getComponent().getAttributes().get("fabSelecionado");
		fabricanteDAO.remove(fabricante);
		Messages.addGlobalInfo("Fabricante "+ fabricante.getNome()+" excluído com sucesso");
		init();		
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
