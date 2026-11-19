package com.pagoflex.reportes.service;

import com.pagoflex.reportes.model.Reporte;
import com.pagoflex.reportes.repository.ReporteRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReporteService {

    private final ReporteRepository reporteRepository;

    public List<Reporte> listar() {
        return reporteRepository.findAll();
    }

    public Reporte obtener(Long id) {
        return reporteRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Reporte no encontrado"));
    }

    public List<Reporte> listarPorUsuario(Long usuarioId) {
        return reporteRepository.findByUsuarioId(usuarioId);
    }

    public Reporte guardar(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public Reporte actualizar(Long id, Reporte datos) {

        Reporte reporte = obtener(id);

        reporte.setUsuarioId(datos.getUsuarioId());
        reporte.setTotalMensual(datos.getTotalMensual());
        reporte.setTotalAnual(datos.getTotalAnual());
        reporte.setFechaGeneracion(datos.getFechaGeneracion());

        return reporteRepository.save(reporte);
    }

    public void eliminar(Long id) {

        Reporte reporte = obtener(id);

        reporteRepository.delete(reporte);
    }
}
