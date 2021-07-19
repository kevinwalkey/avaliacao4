package avaliacao.kevin.controller;

import avaliacao.kevin.controller.dto.PessoaDto;
import avaliacao.kevin.controller.form.AtualizarPessoaForm;
import avaliacao.kevin.controller.form.PessoaForm;
import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.repository.EnderecoRepository;
import avaliacao.kevin.repository.PessoaRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoa")
@Api(value="Pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository pessoaRepository;
    @Autowired
    EnderecoRepository enderecoRepository;

    @PostMapping
    @Transactional
    @ApiOperation(value="Cadastrar pessoa")
    public ResponseEntity<PessoaDto> cadastrar( @RequestBody @Valid PessoaForm form, UriComponentsBuilder uriBuilder) {
        Pessoa pessoa = form.converter(enderecoRepository);
        pessoaRepository.save(pessoa);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(new PessoaDto(pessoa));
    }

    @ApiOperation(value="buscar pessoa")
    @GetMapping
    public ResponseEntity<PessoaDto> lista(String nomePessoa) {
        if (nomePessoa == null) {
            List<Pessoa> pessoas = pessoaRepository.findAll();
            return (ResponseEntity<PessoaDto>) PessoaDto.converter(pessoas);
        } else {
            List<Pessoa> pessoas = (List<Pessoa>) pessoaRepository.findByNome(nomePessoa);
            return (ResponseEntity<PessoaDto>) PessoaDto.converter(pessoas);

        }
    }

    @ApiOperation(value="buscar pessoas por id")
    @GetMapping("/{id}")
    public ResponseEntity<PessoaDto> detalhar(@PathVariable Long id) {
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if (pessoa.isPresent()) {
            return ResponseEntity.ok(new PessoaDto(pessoa.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value="atualizar pessoa")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PessoaDto> atualizar( @PathVariable Long id, @RequestBody @Valid AtualizarPessoaForm form) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.isPresent()) {
            Pessoa pessoa = form.atualizar(id, pessoaRepository);
            return ResponseEntity.ok(new PessoaDto(pessoa));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value="deletar pessoa")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Pessoa> optional = pessoaRepository.findById(id);
        if (optional.isPresent()) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}

