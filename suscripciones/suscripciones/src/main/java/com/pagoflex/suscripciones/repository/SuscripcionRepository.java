package com.pagoflex.suscripciones.repository;

import com.pagoflex.suscripciones.model.Suscripcion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuscripcionRepository
        extends JpaRepository<Suscripcion, Long> {

    List<Suscripcion> findByUsuarioId(Long usuarioId);
}
