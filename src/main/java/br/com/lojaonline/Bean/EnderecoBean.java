package br.com.lojaonline.Bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import org.omnifaces.util.Messages;

import br.com.lojaonline.DAO.BairroDAO;
import br.com.lojaonline.DAO.CidadeDAO;
import br.com.lojaonline.DAO.EnderecoDAO;
import br.com.lojaonline.DAO.EstadoDAO;
import br.com.lojaonline.model.Bairro;
import br.com.lojaonline.model.Cidade;
import br.com.lojaonline.model.Endereco;
import br.com.lojaonline.model.Estado;
import br.com.lojaonline.model.Pessoa;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class EnderecoBean implements Serializable {

	private Estado estado;
	private Cidade cidade;
	private Bairro bairro;

	@Inject
	EstadoDAO estadoDAO;
	@Inject
	CidadeDAO cidadeDAO;
	@Inject
	BairroDAO bairroDAO;
	@Inject
	EnderecoDAO enderecoDAO;

	private List<Estado> estados;
	private List<Cidade> cidades;
	private List<Bairro> bairros;
	private List<Endereco> enderecos;

	@PostConstruct
	private void init() {
		listEstados();
	}

	public void listEstados() {
		estados = estadoDAO.list("nome");
		cidade = new Cidade();
		bairro = new Bairro();
	}

	public void listCidadePorEstado() {
		cidades = cidadeDAO.listaPorEstado(estado.getCodigo());
		bairro = new Bairro();
	}

	public void listBairroPorCidade() {
		bairros = bairroDAO.listaPorCidade(cidade.getCodigo());
	}

	public void carregaEnderecoPessoa(Pessoa pessoa) {
		try {
			if (pessoa != null) {
				estado = pessoa.getEndereco().getBairro().getCidade().getEstado();
				listEstados();

				cidade = pessoa.getEndereco().getBairro().getCidade();
				listCidadePorEstado();

				bairro = pessoa.getEndereco().getBairro();
				listBairroPorCidade();

				listEnderecoPorBairro(pessoa.getEndereco().getLogradouro());
			}
		} catch (NullPointerException exception) {
			estado = new Estado();
			cidade = new Cidade();
			bairro = new Bairro();			
		}

	}

	public List<Endereco> listEnderecoPorBairro(String logradouro) {
		enderecos = enderecoDAO.listaPorBairro(bairro.getCodigo(), logradouro);
		return enderecos;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
}
