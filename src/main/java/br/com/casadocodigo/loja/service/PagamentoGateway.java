package br.com.casadocodigo.loja.service;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;

import br.com.casadocodigo.loja.models.Pagamento;

public class PagamentoGateway implements Serializable{
	private static final long serialVersionUID = 7622699878492502042L;
	
	static final String URL_PAGAMENTO = "http://book-payment.herokuapp.com/payment";
	
	public String pagamento(BigDecimal valorTotal) {
		Pagamento pagamento = new Pagamento(valorTotal);
		
		Client client = ClientBuilder.newClient();

		return client.target(URL_PAGAMENTO).request()
			.post(Entity.json(pagamento), String.class);
	}

}
