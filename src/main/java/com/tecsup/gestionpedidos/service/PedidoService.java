package com.tecsup.gestionpedidos.service;

import com.tecsup.gestionpedidos.dto.DetallePedidoRequest;
import com.tecsup.gestionpedidos.dto.PedidoRequest;
import com.tecsup.gestionpedidos.entity.Cliente;
import com.tecsup.gestionpedidos.entity.DetallePedido;
import com.tecsup.gestionpedidos.entity.Pedido;
import com.tecsup.gestionpedidos.entity.Producto;
import com.tecsup.gestionpedidos.exception.ResourceNotFoundException;
import com.tecsup.gestionpedidos.exception.StockInsuficienteException;
import com.tecsup.gestionpedidos.repository.ClienteRepository;
import com.tecsup.gestionpedidos.repository.PedidoRepository;
import com.tecsup.gestionpedidos.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    public List<Pedido> listar() {
        return pedidoRepository.findAll();
    }

    public Pedido buscarPorId(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pedido no encontrado"));
    }

    public Pedido registrarPedido(PedidoRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        if (request.getDetalles() == null || request.getDetalles().isEmpty()) {
            throw new RuntimeException("El pedido debe contener al menos un producto");
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setFecha(LocalDate.now());

        List<DetallePedido> detalles = new ArrayList<>();
        double total = 0.0;

        for (DetallePedidoRequest detalleRequest : request.getDetalles()) {

            Producto producto = productoRepository.findById(detalleRequest.getProductoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

            Integer cantidad = detalleRequest.getCantidad();

            if (cantidad == null || cantidad <= 0) {
                throw new RuntimeException("La cantidad debe ser mayor a 0");
            }

            if (producto.getStock() < cantidad) {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + producto.getNombre());
            }

            double subtotal = cantidad * producto.getPrecio();

            producto.setStock(producto.getStock() - cantidad);
            productoRepository.save(producto);

            DetallePedido detalle = new DetallePedido();
            detalle.setPedido(pedido);
            detalle.setProducto(producto);
            detalle.setCantidad(cantidad);
            detalle.setSubtotal(subtotal);

            detalles.add(detalle);
            total += subtotal;
        }

        pedido.setDetalles(detalles);
        pedido.setTotal(total);

        return pedidoRepository.save(pedido);
    }

    public void eliminar(Long id) {
        Pedido pedido = buscarPorId(id);
        pedidoRepository.delete(pedido);
    }
}