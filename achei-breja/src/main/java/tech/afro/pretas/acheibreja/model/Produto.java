package tech.afro.pretas.acheibreja.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "tb_produto") // diz ao JPA que essa classe equivale a tabela categoria
public class Produto {

	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nome_produto", nullable = false)
	private String nome;

	@Column(name = "preco_produto", nullable = false)
	private Double preco;

	@Column(name = "volume_produto", nullable = false)
	private String volumeProduto;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	
	@ManyToMany(fetch = FetchType.EAGER) //EAGER força o jpa/hibernate buscar os dados do relacionamento
	@JoinTable(
			name = "tb_produto_estabelecimento",
			joinColumns = { @JoinColumn(name = "id_produto") },
			inverseJoinColumns = { @JoinColumn(name = "id_estabelecimento") }
	)
	@JsonIgnore


	//@JsonIgnore
	//@ManyToMany
	//@JoinTable(name = "tb_produto_estabelecimento", joinColumns = {
	//		@JoinColumn(name = "id_produto") }, inverseJoinColumns = { @JoinColumn(name = "id_estabelecimento") })


	// define o atributo listaEndereco do tipo Set (Conjunto), sendo que
	// esse conjunto só aceita objetos do tipo Estabelecimento
	private Set<Estabelecimento> listaEstabelecimento;

	public Produto() {
		super();
	}


	public Produto(Long id, String nome, Double preco, String volumeProduto, Categoria categoria) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.volumeProduto = volumeProduto;
		this.categoria = categoria;
		this.listaEstabelecimento = new HashSet<Estabelecimento>();
	}

	public String getVolumeProduto() {
		return volumeProduto;
	}

	public void setVolumeProduto(String volumeProduto) {
		this.volumeProduto = volumeProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Set<Estabelecimento> getListaEstabelecimento() {
		return listaEstabelecimento;
	}

	public void setListaEstabelecimento(Set<Estabelecimento> listaEstabelecimento) {
		this.listaEstabelecimento = listaEstabelecimento;
	}


	public Produto findAllByTituloContainingIgnoreCase(String produto) {
		return null;
	}

}
