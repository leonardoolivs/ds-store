package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;

    public ClienteDTO(Cliente cliente){
        id = cliente.getId();
        nome = cliente.getNome();
        cpf = cliente.getCpf();
    }

    public Cliente toEntity() {
        Cliente cliente = new Cliente();
        copyDtoToEntity(cliente);
        return cliente;
    }

    public void copyDtoToEntity(Cliente entity){
        entity.setId(id);
        entity.setNome(nome);
        entity.setCpf(cpf);
    }

}
