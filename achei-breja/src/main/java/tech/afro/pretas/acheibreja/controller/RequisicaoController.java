package tech.afro.pretas.acheibreja.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.transaction.Transactional;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.model.Requisicao;
import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.ProdutoRepository;
import tech.afro.pretas.acheibreja.repository.RequisicaoRepository;
import tech.afro.pretas.acheibreja.repository.UsuarioRepository;
import tech.afro.pretas.acheibreja.service.RequisicaoService;

@Controller
public class RequisicaoController {
	
	
	    @Autowired
	    private RequisicaoService requisicaoService;
	    @Autowired
	    private ProdutoRepository produtoRepository;
	    @Autowired
	    private UsuarioRepository usuarioRepository;
	    
	    @GetMapping
	    public List<Requisicao> listar() {
	        return requisicaoService.listar();
	    }
	    
	    @GetMapping("/{id}")
	    public Optional<Requisicao> obterPorId(@PathVariable Long id) {
	        return requisicaoService.obterPorId(id);
	    }


	    @ResponseBody
	    @Transactional //e usada para definir os requisitos da transacao
	    @RequestMapping(path = "/requisicao/criarRequisicao", method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Requisicao> salvar(@RequestBody Requisicao requisicao) {
	    	System.out.println("ESTOU AQUI!!!!!!!");
	        Logger logger = LoggerFactory.getLogger(getClass());
	        logger.info("Recebendo requisição: {}", requisicao);
	        Usuario usuario = usuarioRepository.findById(requisicao.getUsuario().getId()).orElseThrow();
	        Produto produto = produtoRepository.findById(requisicao.getProduto().getId().toString()).orElseThrow();

	        Requisicao request = new Requisicao();
	        request.setIdRequisicao(requisicao.getId());
	        request.setUsuario(usuario);
	        request.setProduto(produto);
	        request.setIdQuantidadeRequisicao(requisicao.getIdQuantidadeRequisicao());
	        request.setDataRequisicao(requisicao.getDataRequisicao());

	        Requisicao requisicaoSalva = requisicaoService.salvar(request);

	        return ResponseEntity
	                .created(URI.create("/api/requisicoes/" + requisicaoSalva.getId()))
	                .body(requisicaoSalva);
	    }
	    
	    

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> excluir(@PathVariable Long id) {
	        requisicaoService.excluir(id);
	        return ResponseEntity.noContent().build();
	    }
	


//	@ResponseBody
//	@Transactional
//	@RequestMapping(path = "/listarRequisicao", method = RequestMethod.GET)
//	public List<Requisicao> listar(){
//			List<Requisicao> requisicao = requisicaoRepository.findAll();//O metodo findAll busca tudo que estiver na tabela da nossa entidade na base.
//			return requisicao;
//		}
//		
//	@ResponseBody
//	@Transactional
//	@RequestMapping(path = "/atualRequisicao", method = RequestMethod.PUT)
//	public void atualizar(@RequestBody Requisicao requisicao) {
//		requisicaoRepository.save(requisicao);
//	}
	
}


