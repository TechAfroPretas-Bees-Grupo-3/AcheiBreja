package tech.afro.pretas.acheibreja.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "tb_estabelecimento") // diz ao JPA que essa classe equivale a tabela categoria
public class Estabelecimento {
	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
	@Column
	private Long idEstabelecimento;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String bairro;

	@Column(nullable = false)
	private String estabelecimento;
	
	@ManyToMany(mappedBy = "listaEstabelecimento")
	private Set<Produto> listaProduto;

	public Estabelecimento() {
		super();
	}
	
	public Estabelecimento(Long idEstabelecimento, String logradouro, String bairro, String estabelecimento,
			Set<Produto> listaProduto) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estabelecimento = estabelecimento;
		this.listaProduto = listaProduto;
	}

	public Long getIdEndereco() {
		return idEstabelecimento;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEstabelecimento = idEndereco;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Set<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(Set<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}
}
