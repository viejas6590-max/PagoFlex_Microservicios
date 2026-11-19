package com.pagoflex.metodos_pago.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pagoflex.metodos_pago.model.MetodoPago;

import java.util.List;

public interface MetodoPagoRepository
        extends JpaRepository<MetodoPago, Long> {

    List<MetodoPago> findByUsuarioId(Long usuarioId);
}
