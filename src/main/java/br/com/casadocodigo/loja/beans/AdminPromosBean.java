package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;

import br.com.casadocodigo.loja.models.Promo;

@Model
public class AdminPromosBean implements Serializable{
	private static final long serialVersionUID = -2863583718073288407L;
	
	private Promo promo = new Promo();
	
	public void salvar() {
		System.out.println(promo.getTitulo());
		System.out.println(promo.getLivro());
		promo = new Promo();
	}

	public Promo getPromo() {
		return promo;
	}

	public void setPromo(Promo promo) {
		this.promo = promo;
	}

}
