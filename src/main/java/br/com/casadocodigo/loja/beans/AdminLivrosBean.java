package br.com.casadocodigo.loja.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.AutorDao;
import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Autor;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable{
	private static final long serialVersionUID = 9040941408717181755L;
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao livroDao;
	
	private List<Integer> autoresId = new ArrayList<Integer>();
	
	@Inject
	private AutorDao autorDao;
	
	public AdminLivrosBean() {
	}
	
	@Transactional
	public String salvar() {
		for (Integer autorId : autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		livroDao.salvar(livro);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage("Livro Cadastrado com Sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	@Transactional
	public void buscaTodos() {
		List<Livro> livros = livroDao.findFull();
		livros.stream().forEach(System.out::println);
	}
	
	public List<Autor> getAutores(){
		return autorDao.findAll(Autor.class);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}

}
