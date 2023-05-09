package tech.afro.pretas.acheibreja;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.afro.pretas.acheibreja.model.Categoria;
import tech.afro.pretas.acheibreja.model.Endereco;
import tech.afro.pretas.acheibreja.model.Produto;
import tech.afro.pretas.acheibreja.repository.CategoriaRepository;
import tech.afro.pretas.acheibreja.repository.EnderecoRepository;
import tech.afro.pretas.acheibreja.repository.ProdutoRepository;

@SpringBootApplication
public class AcheiBrejaApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AcheiBrejaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria a = new Categoria();
		a.setIdCategoria("C1");
		a.setTipoCategoria("IPA");
		categoriaRepository.save(a);
		
		Categoria b = categoriaRepository.findById("C1").get();
		System.out.println(b.getTipoCategoria());

		Endereco e = new Endereco();
		e.setIdEndereco((long) 1);
		e.setLogradouro("rua da cerveja");
		e.setBairro("taquaral");
		enderecoRepository.save(e);

		Produto p = new Produto();
		p.setId("P1");
		p.setNome("Becks");
		p.setPreco(4.5);
		p.setCategoria(a);

		Set<Endereco> listaEndereco = new HashSet<>();
		listaEndereco.add(e);
		p.setListaEndereco(listaEndereco);
		produtoRepository.save(p);
		
	}

}
