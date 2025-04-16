package com.prova.topicos.services;

import com.prova.topicos.DTOs.EmpregoDTO;
import com.prova.topicos.entities.Emprego;
import com.prova.topicos.repositories.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpregoService {
    @Autowired
    EmpregoRepository repository;

    public Emprego create(Emprego emprego){
        return repository.save(emprego);
    }

    public List<EmpregoDTO> findAll(){

        return repository.findAll()
                .stream()
                .map(EmpregoDTO::new)
                .toList();
    };

    public Emprego findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Emprego não existe"));
    }

    public Emprego update(Long id, Emprego emprego){
        Emprego toUpdate = this.findById(id);
        toUpdate.setEndereco(emprego.getEndereco());
        return repository.save(toUpdate);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}
