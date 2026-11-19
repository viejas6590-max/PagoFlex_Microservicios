package com.pagoflex.reportes.repository;

import com.pagoflex.reportes.model.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReporteRepository
        extends JpaRepository<Reporte, Long> {

    List<Reporte> findByUsuarioId(Long usuarioId);
}
