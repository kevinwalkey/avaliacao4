package avaliacao.kevin.config.security;

import avaliacao.kevin.modelo.Usuario;
import avaliacao.kevin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
class AutenticacaoServico implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = Optional.ofNullable(repository.findByEmail(username));
        if (usuario.isPresent()) {
            return usuario.get();
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }

}
