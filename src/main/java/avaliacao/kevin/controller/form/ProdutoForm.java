package avaliacao.kevin.controller.form;

import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.modelo.Produto;
import avaliacao.kevin.repository.EnderecoRepository;
import avaliacao.kevin.repository.ProdutoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProdutoForm {

    @NotNull @NotEmpty
    private String descricao;
    @NotNull @NotEmpty
    private BigDecimal precoUnitario;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao( String descricao ) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario( BigDecimal precoUnitario ) {
        this.precoUnitario = precoUnitario;
    }

    public Produto converter( ProdutoRepository produtoRepository ){ return new Produto(descricao, precoUnitario);
    }
}
