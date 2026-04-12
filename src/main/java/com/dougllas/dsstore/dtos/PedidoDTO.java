package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.enums.Status;
import com.dougllas.dsstore.models.ItemPorPedido;
import com.dougllas.dsstore.models.Pedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Long id;
    private Long clienteId;
    private BigDecimal total;
    private Instant dataPedido;
    private Status status;

    @NotEmpty
    private List<ItemPorPedidoDTO> itensPorPedido = new ArrayList<>();

    public PedidoDTO(Pedido pedido){
        id = pedido.getId();
        clienteId = pedido.getCliente().getId();
        total = getTotal(pedido);
        dataPedido = pedido.getDataPedido();
        status = pedido.getStatus();

        for(ItemPorPedido item : pedido.getItemPorPedido()){
            itensPorPedido.add(new ItemPorPedidoDTO(item));
        }
    }

    private BigDecimal getTotal(Pedido pedido){
        BigDecimal total = BigDecimal.ZERO;

        for(ItemPorPedido item : pedido.getItemPorPedido()){
            BigDecimal preco = item.getProduto().getPreco();
            BigDecimal quantidade = BigDecimal.valueOf(item.getQuantidade());

            total = total.add(preco.multiply(quantidade));
        }

        return total;
    }
}
