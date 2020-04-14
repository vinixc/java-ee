package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import br.com.casadocodigo.loja.lojas.websockets.PromosEndpoint;
import br.com.casadocodigo.loja.models.Promo;

@Model
public class AdminPromosBean implements Serializable{
	private static final long serialVersionUID = -2863583718073288407L;
	
	private Promo promo = new Promo();
	
	@Inject
	private PromosEndpoint promos;
	
	public void salvar() {
		promos.send(promo);
		promo = new Promo();
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

}
