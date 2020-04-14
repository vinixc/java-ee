package br.com.casadocodigo.loja.security;

import java.security.MessageDigest;

import org.jboss.security.Base64Encoder;

public class PassGenerator {
	
	public static void main(String[] args) {
		System.out.println(new PassGenerator().generated("123"));
	}
	
	
	public String generated(String senhaEmTexto) {
		try {
			byte[] digest = MessageDigest.getInstance("sha-256")
					.digest(senhaEmTexto.getBytes());
			
			return Base64Encoder.encode(digest);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
