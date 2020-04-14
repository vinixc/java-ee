package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seq_system_user", sequenceName = "seq_system_user")
@NamedQueries(value = {
		@NamedQuery(name = SystemUser.FIND_BY_EMAIL, query = ""
				+ "SELECT su FROM SystemUser su JOIN FETCH su.roles WHERE su.email = :email")
})
public class SystemUser {
	
	public static final String FIND_BY_EMAIL = "SystemUser.findByEmail";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_system_user")
	private Integer id;

	private String email;
	
	private String senha;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<SystemRole> roles = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
