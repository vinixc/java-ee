package br.com.casadocodigo.loja.lojas.websockets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import br.com.casadocodigo.loja.models.Promo;

@ServerEndpoint("/canal/promos")
public class PromosEndpoint {
	
	@Inject
	private UsuariosSession usuarios;
	
	@OnOpen
	public void onMessage(Session session){
		usuarios.add(session);
	}
	
	public void send(Promo promo) {
		List<Session> sessions = usuarios.getUsuarios();
		for (Session session : sessions) {
			
			if(session.isOpen()) {
				try {
					session.getBasicRemote().sendText(promo.toJson());
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
			
		}
	}

}
