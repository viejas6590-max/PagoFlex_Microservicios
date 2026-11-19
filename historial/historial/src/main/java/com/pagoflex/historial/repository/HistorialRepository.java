package com.pagoflex.historial.repository;

import com.pagoflex.historial.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistorialRepository
        extends JpaRepository<Movimiento, Long> {

    List<Movimiento> findByUsuarioId(Long usuarioId);
}
