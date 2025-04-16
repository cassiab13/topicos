package com.prova.topicos.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_table")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Emprego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String endereco;

    @ManyToOne
    @JoinColumn(name = "personagem_id")
    @JsonBackReference
    private Pessoa pessoa;

}
