package tech.afro.pretas.acheibreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tech.afro.pretas.acheibreja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public Produto findAllByNomeContainingIgnoreCase(@Param("produto")String nome);
}
