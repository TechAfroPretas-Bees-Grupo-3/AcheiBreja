package tech.afro.pretas.acheibreja.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	@ManyToMany
	@JoinTable(
			name = "produto_endereco",
			joinColumns = { @JoinColumn(name = "id_produto") },
			inverseJoinColumns = { @JoinColumn(name = "id_endereco") }
	)
	private Set<Estabelecimento> listaEndereco;

	public Produto() {
		super();
	}
	

	public Produto(Long id, String nome, Double preco, String volumeProduto, Categoria categoria,
			Set<Estabelecimento> listaEndereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.volumeProduto = volumeProduto;
		this.categoria = categoria;
		this.listaEndereco = listaEndereco;
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

	public Set<Estabelecimento> getListaEndereco() {
		return listaEndereco;
	}

	public void setListaEndereco(Set<Estabelecimento> listaEndereco) {
		this.listaEndereco = listaEndereco;
	}
}