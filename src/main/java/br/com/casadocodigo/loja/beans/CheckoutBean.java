package br.com.casadocodigo.loja.beans;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import br.com.casadocodigo.loja.models.CarrinhoCompras;
import br.com.casadocodigo.loja.models.Compra;
import br.com.casadocodigo.loja.models.Usuario;

@Model
public class CheckoutBean implements Serializable{
	private static final long serialVersionUID = -5990919761291178826L;
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private CarrinhoCompras carrinho;
	
	@Inject
	private FacesContext facesContext;
	
	@Transactional
	public void finalizar() {
		Compra compra = new Compra();
		compra.setUsuario(usuario);
		carrinho.finalizar(compra);
		
		String contextName = facesContext.getExternalContext().getContextName();
		HttpServletResponse response = (HttpServletResponse)
				facesContext.getExternalContext().getResponse();
		
		response.setStatus(307);
		response.setHeader("Location", "/" + contextName + "/service/pagamento?uuid=" + compra.getUuid());
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
