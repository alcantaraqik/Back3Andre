package com.backEnd.matheus.controller;

import com.backEnd.matheus.models.ProdutoDetalhe;
import com.backEnd.matheus.services.ProdutoDetalheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtoDetalhes")

public class ProdutoDetalheController {

    @Autowired
    ProdutoDetalheService service;

    @GetMapping("/lista-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void buscarId(@PathVariable Long id, @RequestBody ProdutoDetalhe produtoDetalhe) {service.findById(produtoDetalhe,id);}

    @PostMapping(value = "consulta-lista-produto-detalhe/{id}")
    public List<ProdutoDetalhe> cusultaProdutoDetalhe(@PathVariable Long id) {

        return service.buscarDetalheProduto(id);
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDetalhe> create(@RequestBody ProdutoDetalhe produtoDetalhe) {
        ProdutoDetalhe produtoDetalheCreated = service.create(produtoDetalhe);

        return ResponseEntity.status(201).body(produtoDetalheCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProdutoDetalhe> update(@RequestBody ProdutoDetalhe produtoDetalhe) {
        ProdutoDetalhe produtoDetalheCreated = service.create(produtoDetalhe);

        return ResponseEntity.status(201).body(produtoDetalheCreated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }



}
