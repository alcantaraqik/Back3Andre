package com.backEnd.matheus.controller;

import com.backEnd.matheus.dto.ProdutoDTO;
import com.backEnd.matheus.models.Produto;
import com.backEnd.matheus.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")

public class ProdutoController {
    @Autowired
    ProdutoService service;

    @GetMapping("/lista-por-nome/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> buscarNome(@PathVariable String nome) {
        return service.listPorNome(nome);}

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Produto> create(@RequestBody Produto produto) {

     try {
        Produto produtoCreated = service.create(produto);

        return ResponseEntity.status(201).body(produtoCreated);

    } catch (Exception e) {

        System.out.println("impossível criar o produto: ");
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    }
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> update(@RequestBody Produto produto) {
        Produto produtoCreated = service.create(produto);

        return ResponseEntity.status(201).body(produtoCreated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/vendas-produtos-alto-lucro")
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> produtosAltoLucro() {

        return service.getProdutosComAltoLucro();

    }

}
