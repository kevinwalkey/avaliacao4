package avaliacao.kevin.controller.dto;

import avaliacao.kevin.modelo.Endereco;
import avaliacao.kevin.modelo.Pessoa;

import java.util.List;
import java.util.stream.Collectors;

public class PessoaDto {
    private Long id;
    private String nome;
    private int cpf;
    private double salario;
    private String sexo;
    private Endereco endereco;

    public PessoaDto ( Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.cpf = pessoa.getCpf();
        this.salario = pessoa.getSalario();
        this.sexo = pessoa.getSexo();
    }
    public PessoaDto (PessoaDto pessoaDto){}


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public double getSalario() {
        return salario;
    }

    public String getSexo() {
        return sexo;
    }

    public static List<PessoaDto> converter( List<Pessoa> pessoas) {
        return pessoas.stream().map(PessoaDto::new).collect(Collectors.toList());
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco( Endereco endereco ) {
        this.endereco = endereco;
    }
}
