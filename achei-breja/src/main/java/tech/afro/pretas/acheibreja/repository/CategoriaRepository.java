package tech.afro.pretas.acheibreja.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import tech.afro.pretas.acheibreja.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	
	public List <Categoria> findAllByTipoCategoriaContainingIgnoreCase(@Param("tipoCategoria") String tipoCategoria);

}
