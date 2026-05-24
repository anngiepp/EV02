package com.tecsup.gestionpedidos.controller;

import com.tecsup.gestionpedidos.dto.PedidoRequest;
import com.tecsup.gestionpedidos.entity.Pedido;
import com.tecsup.gestionpedidos.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<Pedido> listar() {
        return pedidoService.listar();
    }

    @GetMapping("/{id}")
    public Pedido buscar(@PathVariable Long id) {
        return pedidoService.buscarPorId(id);
    }

    @PostMapping
    public Pedido registrar(@RequestBody PedidoRequest request) {
        return pedidoService.registrarPedido(request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pedidoService.eliminar(id);
    }
}