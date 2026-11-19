package com.pagoflex.reportes.controller;

import com.pagoflex.reportes.model.Reporte;
import com.pagoflex.reportes.service.ReporteService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reportes")
@RequiredArgsConstructor
public class ReporteController {

    private final ReporteService reporteService;

    @GetMapping
    public List<Reporte> listar() {
        return reporteService.listar();
    }

    @GetMapping("/{id}")
    public Reporte obtener(@PathVariable Long id) {
        return reporteService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Reporte> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return reporteService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Reporte guardar(@RequestBody Reporte reporte) {
        return reporteService.guardar(reporte);
    }

    @PutMapping("/{id}")
    public Reporte actualizar(
            @PathVariable Long id,
            @RequestBody Reporte reporte) {

        return reporteService.actualizar(id, reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reporteService.eliminar(id);
    }
}
