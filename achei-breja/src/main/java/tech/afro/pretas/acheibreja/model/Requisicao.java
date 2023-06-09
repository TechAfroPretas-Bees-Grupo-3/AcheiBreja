package tech.afro.pretas.acheibreja.model;

import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "tb_requisicao") // diz ao JPA que essa classe equivale a tabela categoria
public class Requisicao {

	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_requisicao")
	private Long idRequisicao;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_produto",referencedColumnName = "id_produto", nullable = false)
	//@OneToOne(mappedBy = "requisicao", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonManagedReference
	private Produto produto;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estabelecimento",nullable = false)
	@OneToOne(mappedBy = "requisicao", cascade = CascadeType.ALL, orphanRemoval = true)
	//@JsonManagedReference
	private Estabelecimento estabelecimento;
	

	@Column(name = "id_quantidade_requisicao")
	private Long idQuantidadeRequisicao;

	@Column(name = "data_requisicao")
	private Calendar dataRequisicao;

	public Requisicao() {
		super();
	}

	public Requisicao(Long idRequisicao, Usuario usuario, Produto produto, Long idQuantidadeRequisicao,
			Calendar dataRequisicao, Estabelecimento estabelecimento) {
		super();
		this.idRequisicao = idRequisicao;
		this.usuario = usuario;
		this.produto = produto;
		this.idQuantidadeRequisicao = idQuantidadeRequisicao;
		this.dataRequisicao = dataRequisicao;
		this.estabelecimento = estabelecimento;
	}

	public Long getIdRequisicao() {
		return idRequisicao;
	}

	public void setIdRequisicao(Long idRequisicao) {
		this.idRequisicao = idRequisicao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Long getIdQuantidadeRequisicao() {
		return idQuantidadeRequisicao;
	}

	public void setIdQuantidadeRequisicao(Long idQuantidadeRequisicao) {
		this.idQuantidadeRequisicao = idQuantidadeRequisicao;
	}

	public Calendar getDataRequisicao() {
		return dataRequisicao;
	}

	public void setDataRequisicao(Calendar dataRequisicao) {
		this.dataRequisicao = dataRequisicao;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return idRequisicao;
	}
	
	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
}
