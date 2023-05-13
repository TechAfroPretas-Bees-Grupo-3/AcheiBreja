package tech.afro.pretas.acheibreja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.afro.pretas.acheibreja.model.Usuario;

//ao estender a classe jpaRepository herdamos os metodos do CRUD
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);

}
