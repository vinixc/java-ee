package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.casadocodigo.loja.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean implements Serializable{
	private static final long serialVersionUID = 9040941408717181755L;
	
	private Livro livro = new Livro();
	
	public AdminLivrosBean() {
	}

	public void salvar() {
		System.out.println("Livro cadastrado: " + livro);
		System.out.println("Livro salvo com sucesso!");
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
