package com.pagoflex.notificaciones.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "notificaciones")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(nullable = false, length = 100)
    private String titulo;

    @Column(nullable = false, length = 255)
    private String mensaje;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "estado_leida", nullable = false)
    private Boolean estadoLeida;
}
