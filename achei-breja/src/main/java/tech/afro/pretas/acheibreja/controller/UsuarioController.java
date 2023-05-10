package tech.afro.pretas.acheibreja.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.UsuarioRepository;

@RestController // config a classe pra se controlador e responder por requisicoes
@RequestMapping(value = "/users") // qual var ser o caminho que o controlador vai responder
public class UsuarioController {

	//pra ter acesso ao dados do user repository deve-se fazer uma composicao
	//usado injecao de dependencia pra que seja instanciado 
	@Autowired
	private UsuarioRepository repository;
	
	//quando faz requisicao web tem utilizar o verbo (get no caso)
	@GetMapping
	public List<Usuario> findAll() {
		List<Usuario> result = repository.findAll();
		return result;
	}
	


	
	
}
