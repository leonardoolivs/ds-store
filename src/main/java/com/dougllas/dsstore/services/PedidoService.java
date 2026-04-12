package com.dougllas.dsstore.services;

import com.dougllas.dsstore.dtos.ClienteDTO;
import com.dougllas.dsstore.dtos.ItemPorPedidoDTO;
import com.dougllas.dsstore.dtos.PedidoDTO;
import com.dougllas.dsstore.enums.Status;
import com.dougllas.dsstore.exceptions.ResourceNotFoundException;
import com.dougllas.dsstore.models.Cliente;
import com.dougllas.dsstore.models.ItemPorPedido;
import com.dougllas.dsstore.models.Pedido;
import com.dougllas.dsstore.models.Produto;
import com.dougllas.dsstore.repositories.ClienteRepository;
import com.dougllas.dsstore.repositories.PedidoRepository;
import com.dougllas.dsstore.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;

    @Transactional
    public PedidoDTO insert(PedidoDTO dto){
        Pedido pedido = new Pedido();

        pedido.setDataPedido(Instant.now());
        pedido.setStatus(Status.CONFIRMADO);

        Cliente cliente = clienteRepository.findById(dto.getClienteId()).orElseThrow(
                () -> new ResourceNotFoundException("Cliente não encontrado"));

        pedido.setCliente(cliente);

        for(ItemPorPedidoDTO itemPorPedidoDTO : dto.getItensPorPedido()){
            Produto produto = produtoRepository.findById(itemPorPedidoDTO.getProdutoId()).orElseThrow(
                    () -> new ResourceNotFoundException("Produto não encontrado"));;

            ItemPorPedido item = itemPorPedidoDTO.toEntity();
            item.setProduto(produto);

            pedido.addItem(item);
        }

        pedido = pedidoRepository.save(pedido);

        return new PedidoDTO(pedido);
    }
}
