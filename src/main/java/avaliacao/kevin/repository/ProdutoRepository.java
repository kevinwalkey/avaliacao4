package avaliacao.kevin.repository;

import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.modelo.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Pessoa findByDescricao( String nomeProduto);
}
