package avaliacao.kevin.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="TB_PESSOA")
public class Pessoa implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int cpf;
    private double salario;
    private String sexo;
    @OneToMany( cascade = CascadeType.REMOVE)
    private List<Endereco> endereco;


    public Pessoa(){
    }

    public Pessoa( String nome, int cpf, double salario, String sexo ) {
    }

    public Long getId() {
        return id;
    }

    public void setId( Long id ) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome( String nome ) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf( int cpf ) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario( double salario ) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo( String sexo ) {
        this.sexo = sexo;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setRespostas(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}

