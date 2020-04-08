package br.com.casadocodigo.loja.daos;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

public class AbstractDao<E> implements Serializable{
	private static final long serialVersionUID = 1861150012174774787L;
	
	@PersistenceContext
	public EntityManager em;
	
	public void salvar(E e) {
		em.joinTransaction();
		em.persist(e);
	}
	
	public void savaLista(Collection<E> e) {
		em.joinTransaction();
		e.stream().forEach(obj ->{
			em.persist(obj);
		});
	}
	
	public void update(E e) {
		em.joinTransaction();
		em.merge(e);
	}
	
	public void updateLista(Collection<E> e) {
		em.joinTransaction();
		e.stream().forEach(obj ->{
			em.merge(obj);
		});
	}
	
	public void delete(E e) {
		em.joinTransaction();
		em.remove(e);
	}
	
	public void deleteLista(Collection<E> e) {
		em.joinTransaction();
		e.stream().forEach(obj -> {
			em.remove(obj);
		});
	}
	
	public E findById(Class<E> e, Integer id) {
		try {
			return em.find(e, id);
		}catch(NoResultException nre) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<E> findAll(Class<E> e){
		return em.createQuery(String.format("SELECT e FROM %s e", e.getName())).getResultList();
	}
}
