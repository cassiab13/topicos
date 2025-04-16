package com.prova.topicos.DTOs;


import com.prova.topicos.entities.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PessoaDTO {
    private String nome;
    private int idade;

    public PessoaDTO(Pessoa pessoa) {
        this.nome = pessoa.getNome();
        this.idade = pessoa.getIdade();
    }
}
