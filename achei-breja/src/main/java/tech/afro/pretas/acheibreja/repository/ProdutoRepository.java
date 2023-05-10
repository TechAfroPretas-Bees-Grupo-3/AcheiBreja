package tech.afro.pretas.acheibreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.afro.pretas.acheibreja.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, String> {

	
}
