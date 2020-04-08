package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao {
	
	@PersistenceContext
	private EntityManager manager;
	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public Livro findById(Integer id) {
		return manager.find(Livro.class, id);
	}
	
	public List<Livro> findFull(){
		return manager.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class).getResultList();
	}
}
