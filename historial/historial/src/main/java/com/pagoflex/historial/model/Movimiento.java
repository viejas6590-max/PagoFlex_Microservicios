package com.pagoflex.historial.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "historial")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 255)
    private String descripcion;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "referencia_id")
    private Long referenciaId;
}
