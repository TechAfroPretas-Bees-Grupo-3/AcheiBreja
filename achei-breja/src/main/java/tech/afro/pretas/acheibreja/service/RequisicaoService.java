package tech.afro.pretas.acheibreja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.afro.pretas.acheibreja.model.Requisicao;
import tech.afro.pretas.acheibreja.model.RequisicaoSemReferencia;
import tech.afro.pretas.acheibreja.repository.RequisicaoRepository;
@Service
public class RequisicaoService {

	public RequisicaoService() {
		// TODO Auto-generated constructor stub
	}
	
	  @Autowired
	    private RequisicaoRepository requisicaoRepository;
	    
	    public List<Requisicao> listar(Long idRequisicao) {
	        return requisicaoRepository.findAll();
	    }
	    
	    public Optional<Requisicao> obterPorId(Long id) {
	        return requisicaoRepository.findById(id);
	              
	    }
	    
	    
	    public List<Requisicao> listarRequisicoes() {
	        return requisicaoRepository.findAll();
	    }
	    
	    public Requisicao salvar(Requisicao requisicao) {
	    	// Verificar se o objeto já possui um ID
	        if (requisicao.getId() != null) {
	            // Se o ID já existir, atualizar o objeto no banco de dados
	            return requisicaoRepository.save(requisicao);
	        } else {
	            // Se o ID não existir, criar um novo objeto no banco de dados
	            return requisicaoRepository.saveAndFlush(requisicao);
	        }
	    }
	    
	    public void excluir(Long id) {
	        requisicaoRepository.deleteById(id);
	    }
	    
	    
	    public Requisicao salvarRequisicao(RequisicaoSemReferencia requisicaoSemReferencia) {
	        Requisicao requisicao = new Requisicao();
	        requisicao.setIdRequisicao(requisicaoSemReferencia.getIdRequisicao());
	        requisicao.setUsuario(requisicaoSemReferencia.getUsuario());
	        requisicao.setProduto(requisicaoSemReferencia.getProduto());
	        requisicao.setEstabelecimento(requisicaoSemReferencia.getEstabelecimento());
	        requisicao.setIdQuantidadeRequisicao(requisicaoSemReferencia.getIdQuantidadeRequisicao());
	        requisicao.setDataRequisicao(requisicaoSemReferencia.getDataRequisicao());
	        return requisicaoRepository.save(requisicao);
	    }
	    

}
