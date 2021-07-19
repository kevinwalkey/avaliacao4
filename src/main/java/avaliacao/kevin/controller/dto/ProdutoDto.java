package avaliacao.kevin.controller.dto;

import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.modelo.Produto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class ProdutoDto {
    private Long id;
    private String descricao;
    private BigDecimal precoUnitario;

    public ProdutoDto( Produto produto ) {
        this.id = produto.getId();
        this.descricao = produto.getDescricao();
        this.precoUnitario = produto.getPrecoUnitario();
    }

    public ProdutoDto(){

    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public static List<ProdutoDto> converter( List<Produto> produtos) {
        return produtos.stream().map(ProdutoDto::new).collect(Collectors.toList());
    }
}
