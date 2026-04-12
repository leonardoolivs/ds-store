package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private String nome;
    private String cpf;

    public ClienteDTO(Cliente cliente){
        nome = cliente.getNome();
        cpf = cliente.getCpf();
    }

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        copyDtoToEntity(cliente);
        return cliente;
    }

    public void copyDtoToEntity(Cliente entity){
        entity.setNome(nome);
        entity.setCpf(cpf);
    }

}
