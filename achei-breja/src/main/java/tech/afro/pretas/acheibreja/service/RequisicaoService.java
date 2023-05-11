package tech.afro.pretas.acheibreja.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.afro.pretas.acheibreja.model.Requisicao;
import tech.afro.pretas.acheibreja.repository.RequisicaoRepository;
@Service
public class RequisicaoService {

	public RequisicaoService() {
		// TODO Auto-generated constructor stub
	}
	
	  @Autowired
	    private RequisicaoRepository requisicaoRepository;
	    
	    public List<Requisicao> listar() {
	        return requisicaoRepository.findAll();
	    }
	    
	    public Optional<Requisicao> obterPorId(Long id) {
	        return requisicaoRepository.findById(id);
	              
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
	    

}
