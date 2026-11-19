package com.pagoflex.metodos_pago.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "metodos_pago")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetodoPago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Column(nullable = false, length = 100)
    private String alias;

    @Column(name = "ultimos_cuatro_digitos", length = 4)
    private String ultimosCuatroDigitos;
}
