package tech.afro.pretas.acheibreja.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.afro.pretas.acheibreja.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findById(Long id);
}
