package avaliacao.kevin.controller.form;
import avaliacao.kevin.modelo.Endereco;
import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.repository.EnderecoRepository;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PessoaForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private int cpf;
    @NotNull @NotEmpty
    private double salario;
    @NotNull @NotEmpty
    private String sexo;
    @NotNull @NotEmpty
    private Endereco endereco;

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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco( Endereco endereco ) {
        this.endereco = endereco;
    }

    public Pessoa converter( EnderecoRepository enderecoRepository ){ return new Pessoa(nome, cpf, salario, sexo);
    }
}
