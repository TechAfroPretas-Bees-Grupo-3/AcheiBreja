package tech.afro.pretas.acheibreja.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.UsuarioRepository;
import tech.afro.pretas.acheibreja.security.JwtService;

@RestController // config a classe pra se controlador e responder por requisicoes
@RequestMapping("/usuarios") // qual var ser o caminho que o controlador vai responder
//@CrossOrigin(origins = "*", allowedHeaders = "*") //nao parece ser necessário pois as chamadas sao feitos pelo postman e nao outros sites
public class UsuarioController {

	// pra ter acesso ao dados do user repository deve-se fazer uma composicao
	// usado injecao de dependencia pra que seja instanciado - instanciar um objeto
	// com o Spring
	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private JwtService usuarioService;

	// quando faz requisicao web tem utilizar o verbo (get no caso)
	@GetMapping("/all")
	@ApiOperation("metodo que retorna todos os usuarios")
	public ResponseEntity<List<Usuario>> findAll() {
		try {
			List<Usuario> result = repository.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable Long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/atualizar/{id}")
	public ResponseEntity<Usuario> update(@Valid @RequestBody Usuario usuarioAtualizar, @PathVariable Long id) {
		Optional<Usuario> usuarioOptional = repository.findById(id);
		if (usuarioOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		usuarioAtualizar.setId(usuarioOptional.get().getId());
		Usuario usuarioSalvo = repository.save(usuarioAtualizar);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usuarioSalvo);
	}

	//@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		if (usuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		repository.deleteById(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@PostMapping("/logar")
	public ResponseEntity<String> logar(@RequestBody Usuario usuario) {
		Optional<Usuario> optionalUsuario = repository.findByEmail(usuario.getEmail());
		if (!optionalUsuario.isPresent()) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("HTTP Status will be INTERNAL_SERVER_ERROR (CODE 500)\n ");
		}
		Usuario u = optionalUsuario.get();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(usuario.getSenha(), u.getSenha())) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body("HTTP Status will be INTERNAL_SERVER_ERROR (CODE 500)\n ");
		}
		String token = usuarioService.generateToken(usuario.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(token);
	}

	// deve ter todo os parametros necessarios para instanciar tipo usuario e salvar
	// usando o repository
	@PostMapping("/cadastrar")
	// está contido o http status (response entity)
	public ResponseEntity<String> cadastrar(@RequestBody Usuario usuario) {
		try {
			// senha hash
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			usuario.setSenha(encoder.encode(usuario.getSenha()));
			repository.save(usuario);
		} catch (Exception e) {
			ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("HTTP Status will be INTERNAL_SERVER_ERROR (CODE 500)\n " + e);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("HTTP Status will be CREATED (CODE 201)\n");
	}
}
