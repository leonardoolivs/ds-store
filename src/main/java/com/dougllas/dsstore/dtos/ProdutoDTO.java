package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.Produto;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private BigDecimal preco;

    public ProdutoDTO(Produto produto){
        id = produto.getId();
        nome = produto.getNome();
        preco = produto.getPreco();
    }

    public Produto toEntity() {
        Produto produto = new Produto();
        copyDtoToEntity(produto);

        return produto;
    }

    public void copyDtoToEntity(Produto entity){
        entity.setId(id);
        entity.setNome(nome);
        entity.setPreco(preco);
    }

}
