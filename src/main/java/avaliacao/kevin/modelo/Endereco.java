package avaliacao.kevin.modelo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TB_ENDERECO")
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.REMOVE)
    private Pessoa pessoa;
    private String pais;
    private String estado;
    private String cidade;
    private int cep;
    private String rua;


    public String getPais() {
        return pais;
    }

    public void setPais( String pais ) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado( String estado ) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade( String cidade ) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep( int cep ) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua( String rua ) {
        this.rua = rua;
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa( Pessoa pessoa ) {
        this.pessoa = pessoa;
    }
}
