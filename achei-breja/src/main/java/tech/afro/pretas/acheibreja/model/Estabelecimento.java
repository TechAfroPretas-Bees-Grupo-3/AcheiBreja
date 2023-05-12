package tech.afro.pretas.acheibreja.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "tb_estabelecimento") // diz ao JPA que essa classe equivale a tabela tb_estabelecimento
public class Estabelecimento {
	@Id // diz ao JPA que esse atributo e equivalente a chave primaria da tabela
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
	
	//tirei o parametro do listaproduto e instanciei o conjunto hash set listaproduto para depois do objeto instanciado adicionar o elemento do conjunto (ovo ou a galinha) 
	public Estabelecimento(Long idEstabelecimento, String logradouro, String bairro, String estabelecimento) {
		super();
		this.idEstabelecimento = idEstabelecimento;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.estabelecimento = estabelecimento;
		this.listaProduto = new HashSet<Produto>();
	}

	public Long getIdEstabelecimento() {
		return idEstabelecimento;
	}

	public void setIdEstabelecimento(Long idEstabelecimento) {
		this.idEstabelecimento = idEstabelecimento;
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

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(String estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Set<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(Set<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

}
