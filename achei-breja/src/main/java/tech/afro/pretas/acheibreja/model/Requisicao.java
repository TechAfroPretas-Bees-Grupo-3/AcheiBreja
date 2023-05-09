package tech.afro.pretas.acheibreja.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "tb_requisicao") // diz ao JPA que essa classe equivale a tabela categoria
public class Requisicao {

	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@Column(name = "id_requisicao")
	private Long idRequisicao;
	
//	@ManyToOne
//	@JoinColumn(name="cart_id", nullable=false)
//	@Column(name = "id_usuario")
//	private Long idUsuario;
////	
//	@ManyToOne
//	@JoinColumn(name = "id_categoria")
//	private Categoria categoria;
	
	@Column(name = "id_quantidade_requisicao")
	private Long idQuantidadeRequisicao;
	
	@Column(name = "data_requisicao")
	private Date dataRequisicao;

	public Requisicao() {
		super();
	}
	
	
	
	
}
