package com.tecsup.gestionpedidos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Table(name = "auditoria_log")
@Data
public class AuditoriaLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accion;

    private String metodo;

    private Timestamp fecha;

    private String usuario;
}