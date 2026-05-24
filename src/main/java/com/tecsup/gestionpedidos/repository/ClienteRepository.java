package com.tecsup.gestionpedidos.repository;

import com.tecsup.gestionpedidos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    boolean existsByCorreo(String correo);

}