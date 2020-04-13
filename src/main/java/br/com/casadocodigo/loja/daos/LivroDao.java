package br.com.casadocodigo.loja.daos;

import java.util.List;

import javax.persistence.Cache;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.QueryHints;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao extends AbstractDao<Livro>{
	private static final long serialVersionUID = 2885753061340543030L;
	
	public void limpaCache() {
		Cache cache = em.getEntityManagerFactory().getCache();
		cache.evict(Livro.class, 1l);
		cache.evictAll();
		
		SessionFactory factory = em.getEntityManagerFactory().unwrap(SessionFactory.class);
		factory.getCache().evictAllRegions();
		factory.getCache().evictQueryRegion("home");
		
	}
	
	public void limpaCacheUltimosLancamentos() {
		SessionFactory factory = em.getEntityManagerFactory().unwrap(SessionFactory.class);
		factory.getCache().evictQueryRegion("homeUltimosLancamentos");
	}
	
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
				.setHint(QueryHints.HINT_CACHE_REGION, "homeUltimosLancamentos")
				.getResultList();
	}
	
	public List<Livro> findDemaisLivros(){
		return em.createNamedQuery(Livro.FIND_FULL_LIVRO, Livro.class)
				.setFirstResult(5)
				.setHint(QueryHints.HINT_CACHEABLE, true)
				.setHint(QueryHints.HINT_CACHE_REGION, "home")
				.getResultList();
	}
}
