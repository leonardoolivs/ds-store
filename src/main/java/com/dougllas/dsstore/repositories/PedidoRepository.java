package com.dougllas.dsstore.repositories;

import com.dougllas.dsstore.models.Cliente;
import com.dougllas.dsstore.models.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
