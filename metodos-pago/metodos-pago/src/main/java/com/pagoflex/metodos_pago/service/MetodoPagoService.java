package com.pagoflex.metodos_pago.service;

import com.pagoflex.metodos_pago.model.MetodoPago;
import com.pagoflex.metodos_pago.repository.MetodoPagoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MetodoPagoService {

    private final MetodoPagoRepository metodoPagoRepository;

    public List<MetodoPago> listar() {
        return metodoPagoRepository.findAll();
    }

    public MetodoPago obtener(Long id) {
        return metodoPagoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Método de pago no encontrado"));
    }

    public List<MetodoPago> listarPorUsuario(Long usuarioId) {
        return metodoPagoRepository.findByUsuarioId(usuarioId);
    }

    public MetodoPago guardar(MetodoPago metodoPago) {
        return metodoPagoRepository.save(metodoPago);
    }

    public MetodoPago actualizar(Long id, MetodoPago datos) {

        MetodoPago metodoPago = obtener(id);

        metodoPago.setUsuarioId(datos.getUsuarioId());
        metodoPago.setTipo(datos.getTipo());
        metodoPago.setAlias(datos.getAlias());
        metodoPago.setUltimosCuatroDigitos(
                datos.getUltimosCuatroDigitos());

        return metodoPagoRepository.save(metodoPago);
    }

    public void eliminar(Long id) {

        MetodoPago metodoPago = obtener(id);

        metodoPagoRepository.delete(metodoPago);
    }
}
