package com.tecsup.gestionpedidos.dto;

import lombok.Data;

import java.util.List;

@Data
public class PedidoRequest {

    private Long clienteId;

    private List<DetallePedidoRequest> detalles;

}