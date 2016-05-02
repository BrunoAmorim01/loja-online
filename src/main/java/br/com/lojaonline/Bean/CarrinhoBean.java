package br.com.lojaonline.Bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.lojaonline.model.Produto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class CarrinhoBean implements Serializable {

	private List<Produto> produtos;

	@PostConstruct
	public void init() {
		produtos = new ArrayList<>();
	}
	
	

}
