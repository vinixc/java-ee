package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.daos.UsuarioDao;
import br.com.casadocodigo.loja.models.Usuario;

@Model
public class CheckoutBean implements Serializable{
	private static final long serialVersionUID = -5990919761291178826L;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Transactional
	public void finalizar() {
		usuarioDao.salvar(usuario);
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
