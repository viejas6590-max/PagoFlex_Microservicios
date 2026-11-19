package com.pagoflex.presupuesto.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "presupuestos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Presupuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "monto_limite", nullable = false)
    private Double montoLimite;

    @Column(nullable = false, length = 7)
    private String mes;
}
