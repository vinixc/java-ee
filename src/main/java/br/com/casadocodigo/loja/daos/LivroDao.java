package br.com.casadocodigo.loja.daos;

import java.util.List;

import org.hibernate.jpa.QueryHints;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao extends AbstractDao<Livro>{
	private static final long serialVersionUID = 2885753061340543030L;
	
	public Livro buscaLivroPeloId(Integer id) {
		return em.createNamedQuery(Livro.FIND_LIVRO_BY_ID, Livro.class)
				.setParameter("id", id)
				.getSingleResult();
	}
		
	public List<Livro> findFull(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class)
				.getResultList();
	}
	
	public List<Livro> findUltimosLancamentos(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class)
				.setMaxResults(5)
				.setHint(QueryHints.HINT_CACHEABLE, true)
				.getResultList();
	}
	
	public List<Livro> findDemaisLivros(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class)
				.setFirstResult(5)
				.setHint(QueryHints.HINT_CACHEABLE, true)
				.getResultList();
	}
}
