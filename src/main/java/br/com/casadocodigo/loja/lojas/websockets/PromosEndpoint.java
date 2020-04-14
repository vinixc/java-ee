package br.com.casadocodigo.loja.lojas.websockets;

import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/canal/promos")
public class PromosEndpoint {
	
	@OnOpen
	public void onMessage(Session session){
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		if(session.isOpen()) {
			try {
				session.getBasicRemote().sendText(
						"{'titulo':'Livro JavaOO com 40% de desconto','livroId':29}");
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
