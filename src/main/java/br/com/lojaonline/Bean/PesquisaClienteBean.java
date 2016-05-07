package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lojaonline.Service.ClienteService;
import br.com.lojaonline.model.Cliente;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class PesquisaClienteBean implements Serializable {

	private List<Cliente> clientes;

	@Inject
	ClienteService clienteService;

	@PostConstruct
	public void init() {
		System.err.println("oi");
		clientes = clienteService.pesquisar();

	}

	public void pesquisar() {

		// clientes = clienteService.pesquisar();
	}

	public List<Cliente> pesquisarClientesPorNome(String cliente) {
		clientes = clienteService.pesquisar(cliente);
		return clientes;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
