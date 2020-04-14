package br.com.casadocodigo.loja.daos;

import br.com.casadocodigo.loja.models.SystemUser;

public class SecurityDao extends AbstractDao<SystemUser>{
	private static final long serialVersionUID = -8341633797195411633L;
	
	public SystemUser findByEmail(String email) {
		return em.createNamedQuery(SystemUser.FIND_BY_EMAIL, SystemUser.class)
			.setParameter("email", email)
			.getSingleResult();
	}

}
