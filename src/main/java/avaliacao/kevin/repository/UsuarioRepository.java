package avaliacao.kevin.repository;

import avaliacao.kevin.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);
}