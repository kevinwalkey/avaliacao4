package avaliacao.kevin.repository;

import avaliacao.kevin.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    Pessoa findById(long id);
    Pessoa findByNome(String nomePessoa);
}