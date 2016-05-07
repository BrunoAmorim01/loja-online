package br.com.lojaonline.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.ClienteDAO;
import br.com.lojaonline.model.Cliente;

@RequestScoped
public class ClienteService {

	@Inject
	private ClienteDAO clienteDAO;

	@Transactional
	public Cliente salvar(Cliente cliente) {
		if (cliente.getPessoa().getDataHoraCadastro() == null) {
			cliente.getPessoa().setDataHoraCadastro(LocalDateTime.now());
		}

		return clienteDAO.merge(cliente);
	}

	@Transactional
	public Cliente loadCliente(Long codigo) {

		return clienteDAO.porID(codigo);
	}

	@Transactional
	public List<Cliente> pesquisar() {

		return clienteDAO.list();
	}
	@Transactional

	public List<Cliente> pesquisar(String nome) {

		return clienteDAO.porNome(nome);
	}
}
