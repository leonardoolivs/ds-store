package com.dougllas.dsstore.dtos;

import com.dougllas.dsstore.enums.Status;
import com.dougllas.dsstore.models.Cliente;
import com.dougllas.dsstore.models.ItemPorPedido;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {

    private Cliente cliente;
    private Status status;
    private Instant dataPedido;

    @NotEmpty
    private List<ItemPorPedido> itemPorPedido = new ArrayList<>();
}
