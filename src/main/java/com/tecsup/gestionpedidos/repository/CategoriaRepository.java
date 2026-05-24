package com.tecsup.gestionpedidos.repository;

import com.tecsup.gestionpedidos.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}