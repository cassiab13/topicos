package com.prova.topicos.controllers;

import com.prova.topicos.DTOs.PessoaDTO;
import com.prova.topicos.entities.Pessoa;
import com.prova.topicos.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    private ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa){
        Pessoa response = service.create(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    private ResponseEntity<List<PessoaDTO>> findAll(){
        List<PessoaDTO> pessoas = service.findAll();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa pessoa = service.findById(id);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa){
        Pessoa toUpdate = service.update(id, pessoa);
        return ResponseEntity.ok(toUpdate);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }
}
