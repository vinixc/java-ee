package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seq_livro", sequenceName = "seq_livro")
@NamedQueries(value = {
		@NamedQuery(name = Livro.FIND_FULL_LIVRO, query = ""
				+ "SELECT l FROM Livro l")
})
public class Livro {
	
	public static final String FIND_FULL_LIVRO = "Livro.findFullLivro";
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
	private Integer id;
	private String titulo;
	@Lob
	private String descricao;
	private BigDecimal preco;
	private Integer numeroPaginas;
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}
	public Integer getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + "]";
	}
}
