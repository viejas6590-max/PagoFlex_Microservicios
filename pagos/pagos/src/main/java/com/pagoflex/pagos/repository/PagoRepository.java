package com.pagoflex.pagos.repository;

import com.pagoflex.pagos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagoRepository
        extends JpaRepository<Pago, Long> {

    List<Pago> findByUsuarioId(Long usuarioId);

    List<Pago> findBySuscripcionId(Long suscripcionId);
}
