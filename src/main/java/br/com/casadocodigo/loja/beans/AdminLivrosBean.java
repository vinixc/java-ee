package br.com.casadocodigo.loja.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.LivroDao;
import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable{
	private static final long serialVersionUID = 9040941408717181755L;
	
	private Livro livro = new Livro();
	
	@Inject
	private LivroDao livroDao;
	
	public AdminLivrosBean() {
	}
	
	@Transactional
	public void salvar() {
		System.out.println("Livro cadastrado: " + livro);
		livroDao.salvar(livro);
		System.out.println("Livro salvo com sucesso!");
		Livro test = livroDao.findById(livro.getId());
		System.out.println(test);
	}
	
	@Transactional
	public void buscaTodos() {
		List<Livro> livros = livroDao.findFull();
		livros.stream().forEach(System.out::println);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
