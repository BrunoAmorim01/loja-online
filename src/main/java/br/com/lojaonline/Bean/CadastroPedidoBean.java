package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.omnifaces.cdi.ViewScoped;
import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.ClienteDAO;
import br.com.lojaonline.DAO.FuncionarioDAO;
import br.com.lojaonline.Service.ClienteService;
import br.com.lojaonline.Service.PedidoService;
import br.com.lojaonline.model.Cliente;
import br.com.lojaonline.model.Funcionario;
import br.com.lojaonline.model.ItemPedido;
import br.com.lojaonline.model.Movimentacao;
import br.com.lojaonline.model.Pedido;
import br.com.lojaonline.model.Produto;
import br.com.lojaonline.model.enumerable.FormaPagamento;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class CadastroPedidoBean implements Serializable {

	private Pedido pedido;

	@Inject
	private PedidoService pedidoService;

	private List<Cliente> clientes;

	@Inject
	ClienteService clienteService;

	@Inject
	FuncionarioDAO funcionarioDAO;

	@PostConstruct
	@Transactional
	public void init() {
		pedido = new Pedido();
		pedido.setItens(new ArrayList<>());
		pedido.setValorDesconto(BigDecimal.ZERO);
		pedido.setValorFrete(BigDecimal.ZERO);
		pedido.setValorTotal(BigDecimal.ZERO);

		addFunc();

	}

	public void salvar() {
		pedidoService.salvar(pedido);
	}

	@Transactional
	public void addFunc() {

		Funcionario funcionario = funcionarioDAO.porID(1l);
		pedido.setFuncionario(funcionario);
	}

	public void addItem(Produto produto) {

		if (existeProdutoNaLista(produto)) {
			pedido.addItemPedido(produto);
		} else {
			Messages.addGlobalError("Produto já está na lista");
		}

		pedido.calcularValorTotal();

	}

	public void atualizaQuantidadeItem() {

		pedido.calcularValorTotal();
	}

	public void removerItem(ItemPedido item) {

		pedido.getItens().remove(item);
		pedido.calcularValorTotal();

	}

	private boolean existeProdutoNaLista(Produto produto) {

		return !pedido.getItens().stream().filter(i -> i.getMovimentacao().getProduto().equals(produto)).findFirst()
				.isPresent();
	}

	public List<Cliente> pesquisarClientesPorNome(String cliente) {
		clientes = clienteService.pesquisar(cliente);
		return clientes;
	}

	public FormaPagamento[] getFormaPagamento() {
		return FormaPagamento.values();
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
