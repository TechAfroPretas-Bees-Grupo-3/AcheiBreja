//Nome do pacote onde a classe foi criada.
package tech.afro.pretas.acheibreja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
//Os imports até aqui indicam todos os pacotes que contém as classes que estão sendo utilizadas na Classe CategoriaController

import jakarta.validation.Valid;
import tech.afro.pretas.acheibreja.model.Categoria;
import tech.afro.pretas.acheibreja.repository.CategoriaRepository;

//Classe do tipo RestController
@RestController

//Esta anotação é usada para mapear as solicitações para os Métodos da Classe controladora CategoriaController
//Através da URL (http://localhost:8080/categoria), o Spring envia a requisição para a classe responsável pelo recurso associado à este endereço
@RequestMapping("/categoria")

//Esta anotação indica que a classe controladora permitirá o recebimento de requisições realizadas de fora do domínio (localhost) ao qual ela pertence
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class CategoriaController {

	//Injeção de Dependência (classes que serão instanciadas e em quais lugares serão injetadas quando houver necessidade)
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<List<Categoria>> getAll(){
		return ResponseEntity.ok(categoriaRepository.findAll());
	}
	
	@GetMapping("/{idCategoria}")
	public ResponseEntity<Categoria> getByIdCategoria(@PathVariable Long idCategoria){
		return categoriaRepository.findById(idCategoria).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	//@PathVariable Long id, insere o valor enviado no endereço do endpoint, na variável de caminho {id}, no parÂmetro do Método getById(Long id)
	}
		
	@PostMapping
	public ResponseEntity<Categoria> post(@Valid @RequestBody Categoria categoria){
	return ResponseEntity.status(HttpStatus.CREATED).body(categoriaRepository.save(categoria));
	//@Valid, valida o objeto categoria enviado no corpo da requisição (request body), conforme as regras definidas na model categoria
	//@RequestBody, recebe o objeto do tipo Categoria (no formato JSON) e insere no parâmetro categoria do método post
		}
	

	@PutMapping
	public ResponseEntity<Categoria> put(@Valid @RequestBody Categoria categoria) {
		return categoriaRepository.findById(categoria.getIdCategoria()).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(categoriaRepository.save(categoria)))
				.orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		
		if(categoria.isEmpty())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		categoriaRepository.deleteById(id);
	}
	
	@GetMapping("/tipoCategoria/{tipoCategoria}")
	public ResponseEntity<List<Categoria>> getByTipoCategoria(@PathVariable String tipoCategoria){
		return ResponseEntity.ok(categoriaRepository.findAllByTipoCategoriaContainingIgnoreCase(tipoCategoria));
	}

	
}
