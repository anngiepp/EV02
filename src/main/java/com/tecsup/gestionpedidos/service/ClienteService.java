package com.tecsup.gestionpedidos.service;

import com.tecsup.gestionpedidos.entity.Cliente;
import com.tecsup.gestionpedidos.exception.ResourceNotFoundException;
import com.tecsup.gestionpedidos.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
    }

    public Cliente guardar(Cliente cliente) {
        if (clienteRepository.existsByCorreo(cliente.getCorreo())) {
            throw new RuntimeException("El correo ya está registrado");
        }
        return clienteRepository.save(cliente);
    }

    public Cliente actualizar(Long id, Cliente cliente) {
        Cliente existente = buscarPorId(id);

        existente.setNombres(cliente.getNombres());
        existente.setApellidos(cliente.getApellidos());
        existente.setCorreo(cliente.getCorreo());
        existente.setTelefono(cliente.getTelefono());
        existente.setDireccion(cliente.getDireccion());

        return clienteRepository.save(existente);
    }

    public void eliminar(Long id) {
        Cliente cliente = buscarPorId(id);
        clienteRepository.delete(cliente);
    }
}