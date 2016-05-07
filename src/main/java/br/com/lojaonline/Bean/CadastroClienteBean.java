package br.com.lojaonline.Bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.util.Messages;

import br.com.lojaonline.Service.ClienteService;
import br.com.lojaonline.model.Cliente;
import br.com.lojaonline.model.Pessoa;
import br.com.lojaonline.model.enumerable.TipoPessoa;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CadastroClienteBean implements Serializable {

	@Inject
	private ClienteService clienteService;

	private Cliente cliente;

	@PostConstruct
	public void init() {
		cliente = new Cliente();
		cliente.setPessoa(new Pessoa());
	}

	public void carregarCliente(Long codigo) {
		cliente = clienteService.loadCliente(codigo);
	}

	public void salvar() {
		cliente = clienteService.salvar(cliente);
		Messages.addGlobalInfo("Cliente " + cliente.getPessoa().getNome() + " salvo com sucesso");
	}

	public TipoPessoa[] getTipoPessoa() {
		return TipoPessoa.values();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
