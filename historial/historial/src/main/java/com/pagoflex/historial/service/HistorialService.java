package com.pagoflex.historial.service;

import com.pagoflex.historial.model.Movimiento;
import com.pagoflex.historial.repository.HistorialRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HistorialService {

    private final HistorialRepository historialRepository;

    public List<Movimiento> listar() {
        return historialRepository.findAll();
    }

    public Movimiento obtener(Long id) {
        return historialRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Movimiento no encontrado"));
    }

    public List<Movimiento> listarPorUsuario(Long usuarioId) {
        return historialRepository.findByUsuarioId(usuarioId);
    }

    public Movimiento guardar(Movimiento movimiento) {
        return historialRepository.save(movimiento);
    }

    public Movimiento actualizar(Long id, Movimiento datos) {

        Movimiento movimiento = obtener(id);

        movimiento.setUsuarioId(datos.getUsuarioId());
        movimiento.setTipo(datos.getTipo());
        movimiento.setDescripcion(datos.getDescripcion());
        movimiento.setFecha(datos.getFecha());
        movimiento.setReferenciaId(datos.getReferenciaId());

        return historialRepository.save(movimiento);
    }

    public void eliminar(Long id) {

        Movimiento movimiento = obtener(id);

        historialRepository.delete(movimiento);
    }
}
