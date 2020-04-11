package br.com.casadocodigo.loja.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "seq_livro", sequenceName = "seq_livro")
@NamedQueries(value = {
		@NamedQuery(name = Livro.FIND_FULL_LIVRO, query = ""
				+ "SELECT distinct(l) FROM Livro l join fetch l.autores order by l.dataPublicacao desc"),
		@NamedQuery(name = Livro.FIND_LIVRO_BY_ID, query = ""
				+ "SELECT distinct(l) FROM Livro l join fetch l.autores WHERE l.id = :id")
})
public class Livro {
	
	public static final String FIND_FULL_LIVRO = "Livro.findFullLivro";
	public static final String FIND_LIVRO_BY_ID = "Livro.findLivroById";

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_livro")
	private Integer id;
	
	@NotNull(message = "O titulo não pode ser nulo")
	private String titulo;
	
	@Lob
	@Length(min = 10)
	@NotNull
	private String descricao;
	
	@DecimalMin("20")
	private BigDecimal preco;
	
	@Min(50)
	private Integer numeroPaginas;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataPublicacao = Calendar.getInstance();
	
	@ManyToMany
	@Size(min = 1)
	@NotNull
	private List<Autor> autores = new ArrayList<Autor>();
	
	private String capaPath;
	
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
	public List<Autor> getAutores() {
		return autores;
	}
	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", autores=" + autores + "]";
	}
	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	public String getCapaPath() {
		return capaPath;
	}
	public void setCapaPath(String capaPath) {
		this.capaPath = capaPath;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
}
