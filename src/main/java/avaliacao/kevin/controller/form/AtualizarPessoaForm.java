package avaliacao.kevin.controller.form;

import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.repository.PessoaRepository;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
public class AtualizarPessoaForm {
    @NotNull @NotEmpty
    private String nome;
    @NotNull @NotEmpty
    private int cpf;
    @NotNull @NotEmpty
    private double salario;
    @NotNull @NotEmpty
    private String sexo;

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


    public Pessoa atualizar( Long id, PessoaRepository pessoaRepository) {
        Pessoa pessoa = pessoaRepository.getOne(id);

        pessoa.setNome(this.nome);
        pessoa.setCpf(this.cpf);
        pessoa.setSalario(this.salario);
        pessoa.setSexo(this.sexo);

        return pessoa;
    }
}

