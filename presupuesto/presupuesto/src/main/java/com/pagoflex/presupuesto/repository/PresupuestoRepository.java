package com.pagoflex.presupuesto.repository;

import com.pagoflex.presupuesto.model.Presupuesto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PresupuestoRepository
        extends JpaRepository<Presupuesto, Long> {

    List<Presupuesto> findByUsuarioId(Long usuarioId);
}
