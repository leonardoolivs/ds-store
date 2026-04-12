package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.ItemPorPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPorPedidoDTO {

    private Long produtoId;
    private Integer quantidade;
    private BigDecimal preco;

    public ItemPorPedidoDTO(ItemPorPedido itemPorPedido){
        quantidade = itemPorPedido.getQuantidade();
        preco = itemPorPedido.getProduto().getPreco();
    }

    public ItemPorPedido toEntity(){
        ItemPorPedido item = new ItemPorPedido();
        copyToEntity(item);

        return item;
    }

    public void copyToEntity(ItemPorPedido entity) {
        entity.setQuantidade(this.quantidade);
    }

}
