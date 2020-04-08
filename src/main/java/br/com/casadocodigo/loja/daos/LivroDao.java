package br.com.casadocodigo.loja.daos;

import java.util.List;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao extends AbstractDao<Livro>{
	private static final long serialVersionUID = 2885753061340543030L;
		
	public List<Livro> findFull(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class).getResultList();
	}
}
