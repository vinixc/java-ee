package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class LivroDetalheBean implements Serializable{
	private static final long serialVersionUID = -6270432796631190404L;
	
	@Inject
	private LivroDao livroDao;
	
	private Livro livro;
	
	private Integer id;
	
	@Transactional
	public void carregaDetalhe() {
		this.livro = livroDao.buscaLivroPeloId(id);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
