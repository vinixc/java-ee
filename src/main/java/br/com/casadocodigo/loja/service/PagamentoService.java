package br.com.casadocodigo.loja.service;

import java.net.URI;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import br.com.casadocodigo.loja.daos.CompraDao;
import br.com.casadocodigo.loja.models.Compra;

@Path("/pagamento")
public class PagamentoService {
	
	@Context
	private ServletContext context;
	
	@Inject
	private PagamentoGateway pagamentoGateway;
	
	@Inject
	private CompraDao compraDao;
	
	@POST
	@Transactional
	public Response pagar(@QueryParam("uuid")String uuid) {
		Compra compra = compraDao.buscaPorUuid(uuid);
		
		pagamentoGateway.pagamento(compra.getTotal());
		
		URI responseURI = UriBuilder.fromPath("http://localhost:8080" + context.getContextPath() + "/index.xhtml")
		.queryParam("msg", "Compra Realizada com Sucesso").build();
		
		Response response = Response.seeOther(responseURI).build();
		
		return response;
	}

}
