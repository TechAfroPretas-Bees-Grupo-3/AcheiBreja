package tech.afro.pretas.acheibreja.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.afro.pretas.acheibreja.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
