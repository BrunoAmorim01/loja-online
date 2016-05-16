package br.com.lojaonline.Service;

import java.time.LocalDateTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.lojaonline.DAO.PedidoDAO;
import br.com.lojaonline.model.Pedido;

@RequestScoped
public class PedidoService {

	@Inject
	PedidoDAO pedidoDAO;

	@Transactional
	public Pedido salvar(Pedido pedido) {
		
		if(pedido.getCodigo()==null){
			pedido.setDataCriacao(LocalDateTime.now());
		}
		
		return pedidoDAO.merge(pedido);

	}

}
