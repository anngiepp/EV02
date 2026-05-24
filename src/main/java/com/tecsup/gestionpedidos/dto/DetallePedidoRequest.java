package com.tecsup.gestionpedidos.dto;

import lombok.Data;

@Data
public class DetallePedidoRequest {

    private Long productoId;

    private Integer cantidad;

}