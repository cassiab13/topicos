package com.prova.topicos.DTOs;

import com.prova.topicos.entities.Emprego;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmpregoDTO {
    private String endereco;

    public EmpregoDTO(Emprego emprego){
        this.endereco = emprego.getEndereco();
    }
}
