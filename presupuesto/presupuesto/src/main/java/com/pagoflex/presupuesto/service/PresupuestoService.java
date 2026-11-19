package com.pagoflex.presupuesto.service;

import com.pagoflex.presupuesto.model.Presupuesto;
import com.pagoflex.presupuesto.repository.PresupuestoRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresupuestoService {

    private final PresupuestoRepository presupuestoRepository;

    public List<Presupuesto> listar() {
        return presupuestoRepository.findAll();
    }

    public Presupuesto obtener(Long id) {
        return presupuestoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Presupuesto no encontrado"));
    }

    public List<Presupuesto> listarPorUsuario(Long usuarioId) {
        return presupuestoRepository.findByUsuarioId(usuarioId);
    }

    public Presupuesto guardar(Presupuesto presupuesto) {
        return presupuestoRepository.save(presupuesto);
    }

    public Presupuesto actualizar(Long id, Presupuesto datos) {

        Presupuesto presupuesto = obtener(id);

        presupuesto.setUsuarioId(datos.getUsuarioId());
        presupuesto.setMontoLimite(datos.getMontoLimite());
        presupuesto.setMes(datos.getMes());

        return presupuestoRepository.save(presupuesto);
    }

    public void eliminar(Long id) {

        Presupuesto presupuesto = obtener(id);

        presupuestoRepository.delete(presupuesto);
    }
}
