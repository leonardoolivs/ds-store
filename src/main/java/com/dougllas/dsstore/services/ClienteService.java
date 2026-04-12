package com.dougllas.dsstore.services;

import com.dougllas.dsstore.dtos.ClienteDTO;
import com.dougllas.dsstore.exceptions.ResourceNotFoundException;
import com.dougllas.dsstore.models.Cliente;
import com.dougllas.dsstore.repositories.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    @Transactional
    public ClienteDTO insert(ClienteDTO dto){
        Cliente cliente = dto.toEntity();

        cliente = repository.save(cliente);

        return new ClienteDTO(cliente);
    }

    @Transactional(readOnly = true)
    public ClienteDTO findById(Long id) {
        Cliente dto = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado"));

        return new ClienteDTO(dto);
    }

}
