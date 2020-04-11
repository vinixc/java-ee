package br.com.casadocodigo.loja.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;
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
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context;
	
	private Part capaLivro;
	
	public AdminLivrosBean() {
	}
	
	@Transactional
	public String salvar() throws IOException {
		if(this.livro.getTitulo().trim().isEmpty()) {
			FacesMessage msg = new FacesMessage("Titulo não pode ser vazio.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
			return null;
		}
		
		livroDao.salvar(livro);
		
		capaLivro.write("/usr/Sistemas/casadocodigo/livros/" + capaLivro.getSubmittedFileName());
		
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
	
	public void validateTitulo(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		
		System.out.println(value);
	}

	public Part getCapaLivro() {
		return capaLivro;
	}

	public void setCapaLivro(Part capaLivro) {
		this.capaLivro = capaLivro;
	}

}
