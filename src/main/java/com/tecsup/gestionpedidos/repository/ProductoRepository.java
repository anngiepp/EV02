package com.tecsup.gestionpedidos.repository;

import com.tecsup.gestionpedidos.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}