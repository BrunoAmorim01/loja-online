package br.com.lojaonline.Bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class TesteBean implements Serializable{

	private Integer numero;
	private Long numero2;
	
	private String palavra;
	
	@PostConstruct
	public void init() {
		String a="99999999999";
		numero2=Long.parseLong(a);
		//numero=Integer.parseInt(a);
	}
	
	public void teste(){
		
		System.err.println(numero);
		System.err.println(numero2);
		System.err.println(palavra);
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Long getNumero2() {
		return numero2;
	}

	public void setNumero2(Long numero2) {
		this.numero2 = numero2;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}
}
