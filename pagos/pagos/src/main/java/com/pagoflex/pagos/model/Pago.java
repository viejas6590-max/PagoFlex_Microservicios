package com.pagoflex.pagos.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "pagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "suscripcion_id", nullable = false)
    private Long suscripcionId;

    @Column(nullable = false)
    private Double monto;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false, length = 30)
    private String estado;
}
