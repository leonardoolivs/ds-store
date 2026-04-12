package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.Cliente;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

    private Long id;
    @NotBlank(message = "{nome.obrigatorio}")
    private String nome;
    @CPF(message = "{cpf.invalido}")
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
