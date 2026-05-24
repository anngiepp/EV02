package com.tecsup.gestionpedidos.service;

import com.tecsup.gestionpedidos.entity.Categoria;
import com.tecsup.gestionpedidos.exception.ResourceNotFoundException;
import com.tecsup.gestionpedidos.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Categoría no encontrada"));
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria actualizar(Long id, Categoria categoria) {
        Categoria existente = buscarPorId(id);

        existente.setNombre(categoria.getNombre());

        return categoriaRepository.save(existente);
    }

    public void eliminar(Long id) {
        Categoria categoria = buscarPorId(id);
        categoriaRepository.delete(categoria);
    }
}