package tech.afro.pretas.acheibreja.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // diz ao JPA que essa e uma classe que deve ser persistida no banco de dados
@Table(name = "categoria") // diz ao JPA que essa classe equivale a tabela categoria
public class Categoria {

	@Id // diz ao JPA que essa atributo e equivalente a chave privamaria da tabela
	@Column(name = "id_categoria")
	private String idCategoria;
	
	@Column(name = "tipo_categoria", nullable = false)
	private String tipoCategoria;

	public Categoria() {
		super();
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

}
