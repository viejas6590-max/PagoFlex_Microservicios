package com.pagoflex.reportes.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "reportes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "total_mensual", nullable = false)
    private Double totalMensual;

    @Column(name = "total_anual", nullable = false)
    private Double totalAnual;

    @Column(name = "fecha_generacion", nullable = false)
    private LocalDate fechaGeneracion;
}
