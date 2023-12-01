package com.backEnd.matheus.controller;

import com.backEnd.matheus.dto.VendaDTO;
import com.backEnd.matheus.models.Venda;
import com.backEnd.matheus.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/venda")
public class VendaController {

    @Autowired
    VendaService service;

    @GetMapping("/lista-por-documento/{documento}")
    @ResponseStatus(HttpStatus.OK)
    public List<Venda> buscarPorDocumento(@PathVariable String documento) {
        return service.listPorDocumento(documento);}

    @GetMapping("/lista-por-id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void buscarId(@PathVariable Long id, @RequestBody Venda venda) {service.findById(venda,id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Venda> create(@RequestBody Venda venda) {
        Venda vendaCreated = service.create(venda);

        return ResponseEntity.status(201).body(vendaCreated);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Venda> update(@RequestBody Venda venda) {
        Venda vendaCreated = service.create(venda);

        return ResponseEntity.status(201).body(vendaCreated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/vendas-sem-doc")
    @ResponseStatus(HttpStatus.OK)
    public List<VendaDTO> studentGrades() {
        return service.listVendasSemDoc();
    }

}
