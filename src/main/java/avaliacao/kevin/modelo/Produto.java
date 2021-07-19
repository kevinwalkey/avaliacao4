package avaliacao.kevin.modelo;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="TB_PRODUTO")
public class Produto {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private BigDecimal precoUnitario;

    public Produto( String descricao, BigDecimal precoUnitario ) {
    }

    public Produto () {
    }
    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

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
}
