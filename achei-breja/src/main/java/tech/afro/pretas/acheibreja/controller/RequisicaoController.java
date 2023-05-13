package tech.afro.pretas.acheibreja.controller;

import java.net.URI;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.transaction.Transactional;
import tech.afro.pretas.acheibreja.model.Estabelecimento;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.model.Requisicao;
import tech.afro.pretas.acheibreja.model.RequisicaoSemReferencia;
import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.EstabelecimentoRepository;
import tech.afro.pretas.acheibreja.repository.ProdutoRepository;
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
	@Transactional // e usada para definir os requisitos da transacao
	@PostMapping(path = "/requisicao/salvarRequisicao")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Requisicao> salvarRequisicao(@RequestBody RequisicaoSemReferencia requisicaoSemReferencia)
			throws JsonProcessingException {
		Requisicao requisicao = requisicaoService.salvarRequisicao(requisicaoSemReferencia);
		return ResponseEntity.status(HttpStatus.CREATED).body(requisicao);
	}

	@ResponseBody
	@Transactional // e usada para definir os requisitos da transacao
	@PostMapping(path = "/requisicao/criarRequisicao")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Requisicao> salvar(@RequestBody Requisicao requisicao) {
		Logger logger = LoggerFactory.getLogger(getClass());
		logger.info("Recebendo requisição: {}", requisicao);
		Usuario usuario = usuarioRepository.findById(requisicao.getUsuario().getId()).orElseThrow();
		Produto produto = produtoRepository.findById(requisicao.getProduto().getId()).orElseThrow();
		Estabelecimento estabelecimento = estabelecimentoRepository
				.findById(requisicao.getEstabelecimento().getIdEstabelecimento()).orElseThrow();
		Requisicao request = new Requisicao();
		request.setIdRequisicao(requisicao.getId());
		request.setUsuario(usuario);
		request.setProduto(produto);
		request.setEstabelecimento(estabelecimento);
		request.setIdQuantidadeRequisicao(requisicao.getIdQuantidadeRequisicao());
		request.setDataRequisicao(requisicao.getDataRequisicao());

		Requisicao requisicaoSalva = requisicaoService.salvar(request);

		return ResponseEntity.created(URI.create("/api/requisicoes/" + requisicaoSalva.getId())).body(requisicaoSalva);
	}

	@DeleteMapping("/requisicao/{id}")
	public ResponseEntity<Requisicao> excluir(@PathVariable Long id) {
		Optional<Requisicao> requisicaOptional = requisicaoService.obterPorId(id);
		if (requisicaOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		requisicaoService.excluir(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
