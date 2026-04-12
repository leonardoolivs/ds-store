package com.dougllas.dsstore.services;

import com.dougllas.dsstore.dtos.ClienteDTO;
import com.dougllas.dsstore.dtos.ProdutoDTO;
import com.dougllas.dsstore.exceptions.ResourceNotFoundException;
import com.dougllas.dsstore.models.Cliente;
import com.dougllas.dsstore.models.Produto;
import com.dougllas.dsstore.repositories.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProdutoService {

    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository){
        this.repository = repository;
    }

    @Transactional
    public ProdutoDTO insert(ProdutoDTO dto){
        Produto produto = dto.toEntity();

        produto = repository.save(produto);

        return new ProdutoDTO(produto);
    }

    @Transactional(readOnly = true)
    public ProdutoDTO findById(Long id) {
        Produto dto = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Produto não encontrado"));

        return new ProdutoDTO(dto);
    }
}
