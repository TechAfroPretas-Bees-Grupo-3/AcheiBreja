//Nome do pacote onde a classe foi criada.
package tech.afro.pretas.acheibreja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//Os imports até aqui indicam todos os pacotes que contém as classes que estão sendo utilizadas na Classe CategoriaController

import tech.afro.pretas.acheibreja.model.*;
import tech.afro.pretas.acheibreja.repository.*;

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
	
}
