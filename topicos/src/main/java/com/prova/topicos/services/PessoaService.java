package com.prova.topicos.services;

import com.prova.topicos.DTOs.PessoaDTO;
import com.prova.topicos.entities.Pessoa;
import com.prova.topicos.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public Pessoa create(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public List<PessoaDTO> findAll(){

        return repository.findAll()
                .stream()
                .map(PessoaDTO::new)
                .toList();
    };

    public Pessoa findById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
    }

    public Pessoa update(Long id, Pessoa pessoa){
        Pessoa toUpdate = this.findById(id);
        toUpdate.setNome(pessoa.getNome());
        toUpdate.setIdade(pessoa.getIdade());
        return repository.save(toUpdate);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
