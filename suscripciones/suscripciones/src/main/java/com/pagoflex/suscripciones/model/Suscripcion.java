package com.pagoflex.suscripciones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "suscripciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "categoria_id", nullable = false)
    private Long categoriaId;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(nullable = false, length = 30)
    private String estado;
}
