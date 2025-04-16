package com.prova.topicos.controllers;

import com.prova.topicos.DTOs.EmpregoDTO;
import com.prova.topicos.entities.Emprego;
import com.prova.topicos.services.EmpregoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprego")
public class EmpregoController {

    @Autowired
    private EmpregoService service;

    @PostMapping
    private ResponseEntity<Emprego> create(@RequestBody Emprego emprego){
        Emprego response = service.create(emprego);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    private ResponseEntity<List<EmpregoDTO>> findAll(){
        List<EmpregoDTO> empregos = service.findAll();
        return ResponseEntity.ok(empregos);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Emprego> findById(@PathVariable Long id){
        Emprego emprego = service.findById(id);
        return ResponseEntity.ok(emprego);
    }

    @PutMapping("/{id}")
    private ResponseEntity<Emprego> update(@PathVariable Long id, @RequestBody Emprego emprego){
        Emprego toUpdate = service.update(id, emprego);
        return ResponseEntity.ok(toUpdate);
    }

    @DeleteMapping("/{id}")
    private void delete(@PathVariable Long id){
        service.delete(id);
    }
}
