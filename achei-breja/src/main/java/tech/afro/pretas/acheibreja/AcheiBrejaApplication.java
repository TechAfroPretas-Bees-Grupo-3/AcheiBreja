package tech.afro.pretas.acheibreja;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.afro.pretas.acheibreja.model.Categoria;
import tech.afro.pretas.acheibreja.model.Estabelecimento;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.model.Usuario;
import tech.afro.pretas.acheibreja.repository.CategoriaRepository;
import tech.afro.pretas.acheibreja.repository.EstabelecimentoRepository;
import tech.afro.pretas.acheibreja.repository.ProdutoRepository;
import tech.afro.pretas.acheibreja.repository.UsuarioRepository;

@SpringBootApplication
public class AcheiBrejaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstabelecimentoRepository estabelecimentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(AcheiBrejaApplication.class, args);
		
	}


	@Override
	public void run(String... args) throws Exception {
		
		//Elementos tabela categoria
		Categoria c1 = new Categoria(null, "Pilsen");
		categoriaRepository.save(c1);
		
		Categoria c2 = new Categoria(null, "Lager");
		categoriaRepository.save(c2);
		
		Categoria c3 = new Categoria(null, "IPA");
		categoriaRepository.save(c3);
		
		//Elementos tabela usuario
		Usuario u1 = new Usuario(null, "Aisla Alcantara", "aisla@gmail.com", "abc123");
		Usuario u2 = new Usuario(null, "Carolaine Marquezini", "carol@gmail.com", "abc123");
		Usuario u3 = new Usuario(null, "Daiane Goncalves", "dai@gmail.com", "abc123");
		Usuario u4 = new Usuario(null, "Marília Fileto ", "mari@gmail.com", "abc123");
		Usuario u5 = new Usuario(null, "Viviane Neres", "vivi@gmail.com", "abc123");
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		
		//Elementos tabela produto
		Produto p1 = new Produto(null, "Patagonia Bohemian", 5.79, "350ml", c1, null);
		Produto p2 = new Produto(null, "Quilmes", 7.90, "473ml", c2, null);
		Produto p3 = new Produto(null, "Budweiser zero", 3.99, "269ml", c2, null);
		Produto p4 = new Produto(null, "Colorado Indica", 4.72, "350ml", c3, null);
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		//Elementos tabela estabelecimento
		Estabelecimento e1 = new Estabelecimento(null, "Rua Américo Brasiliense", "Cambui", "Tatu Bola", null);
		Estabelecimento e2 = new Estabelecimento(null, "Rua Dr. Heitor Penteado", "Joaquim Egídio", "Bar do Caixote", null);
		Estabelecimento e3 = new Estabelecimento(null, "Av. Barão de Itapura", "Taquaral", "Dom Brejas", null);
		Estabelecimento e4 = new Estabelecimento(null, "Rua Horácio Leonardi", "Barão Geraldo", "Estação Barão", null);
		estabelecimentoRepository.saveAll(Arrays.asList(e1, e2, e3, e4));
	
	
	}
}
