package tech.afro.pretas.acheibreja.model;

import java.util.Calendar;

public class RequisicaoSemReferencia {

    private Long idRequisicao;
	
    private Usuario usuario;

    private Produto produto;
	
    private Estabelecimento estabelecimento;
	
    private Long idQuantidadeRequisicao;
	
    private Calendar dataRequisicao;

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

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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

   
}
