package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.models.Pedido;
import com.dougllas.dsstore.models.Produto;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemPorPedidoDTO {

    private Produto produto;

    private Integer quantidade;

}
