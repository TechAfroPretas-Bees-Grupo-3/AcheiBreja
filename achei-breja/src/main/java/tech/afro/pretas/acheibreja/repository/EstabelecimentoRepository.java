package tech.afro.pretas.acheibreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.afro.pretas.acheibreja.model.Estabelecimento;
import tech.afro.pretas.acheibreja.model.Produto;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Long> {

	// Busca estabelecimento por produto
	List<Estabelecimento> findByListaProduto(Produto produto);

}
