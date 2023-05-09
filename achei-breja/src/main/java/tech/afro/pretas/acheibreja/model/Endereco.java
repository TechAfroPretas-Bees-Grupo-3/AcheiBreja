package tech.afro.pretas.acheibreja.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "endereco") // diz ao JPA que essa classe equivale a tabela categoria
public class Endereco {
	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@Column(name = "id_endereco")
	private Long idEndereco;

	@Column(nullable = false)
	private String logradouro;

	@Column(nullable = false)
	private String bairro;

	@ManyToMany(mappedBy = "listaEndereco")
	private Set<Produto> listaProduto;

	public Endereco() {
		super();
	}

	public Long getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
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
