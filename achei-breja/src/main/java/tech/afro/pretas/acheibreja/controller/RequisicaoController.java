package tech.afro.pretas.acheibreja.controller;

import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.transaction.Transactional;
import tech.afro.pretas.acheibreja.model.Estabelecimento;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.model.Requisicao;
import tech.afro.pretas.acheibreja.model.RequisicaoSemReferencia;
import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.EstabelecimentoRepository;
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
	    @Autowired
	    private EstabelecimentoRepository estabelecimentoRepository;
	    @Autowired
	    private RequisicaoRepository requisicaoRepository;
	    
	    
//	    @GetMapping("/requisicao")
//	    public List<Requisicao> listar(@RequestParam("requisicao") String idRequisicaoString) {
//	        Long idRequisicao = Long.parseLong(idRequisicaoString);
//	        return requisicaoService.listar(idRequisicao);
//	    }
	    @Transactional
	    @GetMapping("/requisicao")
	    @ResponseBody
	    public List<Requisicao> listarRequisicoes() {
	        return requisicaoService.listarRequisicoes();
	    }
	    @Transactional
	    @GetMapping("/requisicao/{id}")
	    @ResponseBody
	    public Optional<Requisicao> obterPorId(@PathVariable Long id) {
	        return requisicaoService.obterPorId(id);
	    }


	    @ResponseBody
	    @Transactional //e usada para definir os requisitos da transacao
	    @RequestMapping(path = "/requisicao/salvarRequisicao", method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<String> salvarRequisicao(@RequestBody RequisicaoSemReferencia requisicaoSemReferencia) throws JsonProcessingException {
	        Requisicao requisicao = requisicaoService.salvarRequisicao(requisicaoSemReferencia);
	        String json = new ObjectMapper().writeValueAsString(requisicao);
	        return ResponseEntity.status(HttpStatus.CREATED).body(json);
	    }
	    
	    @ResponseBody
	    @Transactional //e usada para definir os requisitos da transacao
	    @RequestMapping(path = "/requisicao/criarRequisicao", method = RequestMethod.POST)
	    @ResponseStatus(HttpStatus.CREATED)
	    public ResponseEntity<Requisicao> salvar(@RequestBody Requisicao requisicao) {
	        Logger logger = LoggerFactory.getLogger(getClass());
	        logger.info("Recebendo requisição: {}", requisicao);
	        Usuario usuario = usuarioRepository.findById(requisicao.getUsuario().getId()).orElseThrow();
	        Produto produto = produtoRepository.findById(requisicao.getProduto().getId()).orElseThrow();
	        Estabelecimento estabelecimento = estabelecimentoRepository.findById(requisicao.getEstabelecimento().getIdEstabelecimento()).orElseThrow();
	        Requisicao request = new Requisicao();
	        request.setIdRequisicao(requisicao.getId());
	        request.setUsuario(usuario);
	        request.setProduto(produto);
	        request.setEstabelecimento(estabelecimento);
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
	


//	    @ResponseBody
//	    @Transactional
//	    @RequestMapping(path = "/requisicao", method = RequestMethod.GET)
//	    public List<Requisicao> listar() {
//	        List<Requisicao> requisicao = requisicaoRepository.findAll();
//	        requisicao.forEach(req -> {
//	            Hibernate.initialize(req.getProduto());
//	            Hibernate.initialize(req.getUsuario());
//	            Hibernate.initialize(req.getEstabelecimento());
//	        });
//	        return requisicao;
//	    }
//		
//	@ResponseBody
//	@Transactional
//	@RequestMapping(path = "/atualRequisicao", method = RequestMethod.PUT)
//	public void atualizar(@RequestBody Requisicao requisicao) {
//		requisicaoRepository.save(requisicao);
//	}
	
}


