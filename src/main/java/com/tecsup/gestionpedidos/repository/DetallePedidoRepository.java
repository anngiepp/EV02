package com.tecsup.gestionpedidos.repository;

import com.tecsup.gestionpedidos.entity.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
}