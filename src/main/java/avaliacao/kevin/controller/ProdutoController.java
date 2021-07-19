package avaliacao.kevin.controller;


import avaliacao.kevin.controller.dto.PessoaDto;
import avaliacao.kevin.controller.dto.ProdutoDto;
import avaliacao.kevin.controller.form.AtualizarPessoaForm;
import avaliacao.kevin.controller.form.AtualizarProdutoForm;
import avaliacao.kevin.controller.form.PessoaForm;
import avaliacao.kevin.controller.form.ProdutoForm;
import avaliacao.kevin.modelo.Pessoa;
import avaliacao.kevin.modelo.Produto;
import avaliacao.kevin.repository.ProdutoRepository;
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

@Api(value="Produto")
@RestController
@RequestMapping(value = "/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @ApiOperation(value="Cadastra produto")
    @PostMapping
    @Transactional
    public ResponseEntity<ProdutoDto> cadastrar( @RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
        Produto produto = form.converter(produtoRepository);
        produtoRepository.save(produto);

        URI uri = uriBuilder.path("/produtos/{id}").buildAndExpand(produto.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoDto(produto));
    }

    @ApiOperation(value="buscar produto")
    @GetMapping
    public ResponseEntity<ProdutoDto> lista(String nomeProduto) {
        if (nomeProduto == null) {
            List<Produto> produtos = produtoRepository.findAll();
            return (ResponseEntity<ProdutoDto>) ProdutoDto.converter(produtos);
        } else {
            List<Produto> produtos = (List<Produto>) produtoRepository.findByDescricao(nomeProduto);
            return (ResponseEntity<ProdutoDto>) ProdutoDto.converter(produtos);

        }
    }

    @ApiOperation(value="buscar produto por id")
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return ResponseEntity.ok(new ProdutoDto(produto.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value="atualizar produto")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutoDto> atualizar( @PathVariable Long id, @RequestBody @Valid AtualizarProdutoForm form) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            Produto produto = form.atualizar(id, produtoRepository);
            return ResponseEntity.ok(new ProdutoDto(produto));
        }

        return ResponseEntity.notFound().build();
    }

    @ApiOperation(value="deletar produto")
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Produto> optional = produtoRepository.findById(id);
        if (optional.isPresent()) {
            produtoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}
