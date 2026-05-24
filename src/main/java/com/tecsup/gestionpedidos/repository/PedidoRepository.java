package com.tecsup.gestionpedidos.repository;

import com.tecsup.gestionpedidos.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}