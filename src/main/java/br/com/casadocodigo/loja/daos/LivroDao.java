package br.com.casadocodigo.loja.daos;

import java.util.List;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao extends AbstractDao<Livro>{
	private static final long serialVersionUID = 2885753061340543030L;
		
	public List<Livro> findFull(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class).getResultList();
	}
	
	public List<Livro> findUltimosLancamentos(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class).setMaxResults(5).getResultList();
	}
	
	public List<Livro> findDemaisLivros(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class).setFirstResult(6).getResultList();
	}
}
