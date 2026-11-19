package com.pagoflex.suscripciones.service;

import com.pagoflex.suscripciones.model.Suscripcion;
import com.pagoflex.suscripciones.repository.SuscripcionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuscripcionService {

    private final SuscripcionRepository suscripcionRepository;

    public List<Suscripcion> listar() {
        return suscripcionRepository.findAll();
    }

    public Suscripcion obtener(Long id) {
        return suscripcionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Suscripción no encontrada"));
    }

    public List<Suscripcion> listarPorUsuario(Long usuarioId) {
        return suscripcionRepository.findByUsuarioId(usuarioId);
    }

    public Suscripcion guardar(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    public Suscripcion actualizar(Long id, Suscripcion datos) {

        Suscripcion suscripcion = obtener(id);

        suscripcion.setUsuarioId(datos.getUsuarioId());
        suscripcion.setCategoriaId(datos.getCategoriaId());
        suscripcion.setNombre(datos.getNombre());
        suscripcion.setPrecio(datos.getPrecio());
        suscripcion.setFechaVencimiento(datos.getFechaVencimiento());
        suscripcion.setEstado(datos.getEstado());

        return suscripcionRepository.save(suscripcion);
    }

    public void eliminar(Long id) {

        Suscripcion suscripcion = obtener(id);

        suscripcionRepository.delete(suscripcion);
    }
}