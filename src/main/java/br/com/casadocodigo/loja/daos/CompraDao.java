package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.Compra;

public class CompraDao extends AbstractDao<Compra>{
	private static final long serialVersionUID = -1792298096705104660L;

	public Compra buscaPorUuid(String uuid) {
		return em.createNamedQuery(Compra.FIND_COMPRA_BY_UUID, Compra.class)
			.setParameter("uuid", uuid)
			.getSingleResult();
	}
	
	
}
