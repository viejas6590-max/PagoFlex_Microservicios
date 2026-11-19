package com.pagoflex.historial.controller;

import com.pagoflex.historial.model.Movimiento;
import com.pagoflex.historial.service.HistorialService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@RequiredArgsConstructor
public class HistorialController {

    private final HistorialService historialService;

    @GetMapping
    public List<Movimiento> listar() {
        return historialService.listar();
    }

    @GetMapping("/{id}")
    public Movimiento obtener(@PathVariable Long id) {
        return historialService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Movimiento> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return historialService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Movimiento guardar(@RequestBody Movimiento movimiento) {
        return historialService.guardar(movimiento);
    }

    @PutMapping("/{id}")
    public Movimiento actualizar(
            @PathVariable Long id,
            @RequestBody Movimiento movimiento) {

        return historialService.actualizar(id, movimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        historialService.eliminar(id);
    }
}
