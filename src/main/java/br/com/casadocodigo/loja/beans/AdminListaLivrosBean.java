package br.com.casadocodigo.loja.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class AdminListaLivrosBean implements Serializable{
	
	private static final long serialVersionUID = 205102716479705629L;
	
	@Inject
	private LivroDao livroDao;

	private List<Livro> livros = new ArrayList<>();

	@Transactional
	public List<Livro> getLivros() {
		this.livros = livroDao.findFull();
		return livros;
	}
}
