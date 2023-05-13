package tech.afro.pretas.acheibreja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import tech.afro.pretas.acheibreja.model.Estabelecimento;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.repository.EstabelecimentoRepository;
import tech.afro.pretas.acheibreja.repository.ProdutoRepository;

@RestController
@RequestMapping("/estabelecimentos")
public class EstabelecimentoController {

	@Autowired
	private EstabelecimentoRepository repository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@PostMapping("/criar")
	public ResponseEntity<Estabelecimento> create(@Valid @RequestBody Estabelecimento estabelecimento) {
		System.out.println("[ESTABELECIMENTOS] CRIANDO ESTABELECIMENTO...");

		Estabelecimento estabelecimentoCriado = repository.save(estabelecimento);

		return ResponseEntity.status(HttpStatus.CREATED).body(estabelecimentoCriado);
	}

	@GetMapping("/buscar/all")
	public List<Estabelecimento> getAll() {
		System.out.println("[ESTABELECIMENTO] BUSCANDO TODOS...");

		return repository.findAll();
	}

	@GetMapping("/buscar/{id}")
	public ResponseEntity<Estabelecimento> getById(@PathVariable Long id) {
		System.out.println("[ESTABELECIMENTO] BUSCANDO POR ID...");

		Optional<Estabelecimento> estabelecimentoBuscado = repository.findById(id);

		if (estabelecimentoBuscado.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		return ResponseEntity.ok(estabelecimentoBuscado.get());
	}

	@GetMapping("/buscar/produto/{idProduto}")
	public List<Estabelecimento> getByIdProduto(@PathVariable Long idProduto) {
		System.out.println("[ESTABELECIMENTO] BUSCANDO POR ID PRODUTO...");

		Optional<Produto> produtoBuscado = produtoRepository.findById(idProduto);

		if (produtoBuscado.isEmpty()) {
			return List.of();
		}

		return repository.findByListaProduto(produtoBuscado.get());

	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Estabelecimento> update(@Valid @RequestBody Estabelecimento estabelecimentoParaAtualizar,
			@PathVariable Long id) {
		System.out.println("[ESTABELECIMENTO] ATUALIZANDO ESTABELECIMENTO...");

		Optional<Estabelecimento> estabelecimentoBuscado = repository.findById(id);

		if (estabelecimentoBuscado.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		Estabelecimento estabelecimentoSalvo = repository.save(estabelecimentoParaAtualizar);
	
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(estabelecimentoSalvo);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/deletar/{id}")
	public void delete(@PathVariable Long id) {
		System.out.println("[ESTABELECIMENTO] DELETANDO ESTABELECIMENTO...");

		Optional<Estabelecimento> estabelecimentoBuscado = repository.findById(id);

		if (estabelecimentoBuscado.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

		repository.deleteById(id);
	}
}
