package br.com.casadocodigo.loja.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Model
public class HomeBean implements Serializable{
	private static final long serialVersionUID = -3352263574183935563L;
	
	@Inject
	private LivroDao livroDao;
	
	@Transactional
	public List<Livro> ultimosLancamentos(){
		return livroDao.findUltimosLancamentos();
	}
	
	@Transactional
	public List<Livro> demaisLivros(){
		return livroDao.findDemaisLivros();
	}
}
