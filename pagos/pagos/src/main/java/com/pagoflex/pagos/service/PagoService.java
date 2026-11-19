package com.pagoflex.pagos.service;

import com.pagoflex.pagos.model.Pago;
import com.pagoflex.pagos.repository.PagoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PagoService {

    private final PagoRepository pagoRepository;

    public List<Pago> listar() {
        return pagoRepository.findAll();
    }

    public Pago obtener(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Pago no encontrado"));
    }

    public List<Pago> listarPorUsuario(Long usuarioId) {
        return pagoRepository.findByUsuarioId(usuarioId);
    }

    public List<Pago> listarPorSuscripcion(Long suscripcionId) {
        return pagoRepository.findBySuscripcionId(suscripcionId);
    }

    public Pago guardar(Pago pago) {
        return pagoRepository.save(pago);
    }

    public Pago actualizar(Long id, Pago datos) {

        Pago pago = obtener(id);

        pago.setUsuarioId(datos.getUsuarioId());
        pago.setSuscripcionId(datos.getSuscripcionId());
        pago.setMonto(datos.getMonto());
        pago.setFecha(datos.getFecha());
        pago.setEstado(datos.getEstado());

        return pagoRepository.save(pago);
    }

    public void eliminar(Long id) {

        Pago pago = obtener(id);

        pagoRepository.delete(pago);
    }
}