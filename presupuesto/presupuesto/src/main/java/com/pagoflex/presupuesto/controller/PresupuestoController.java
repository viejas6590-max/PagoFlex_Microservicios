package com.pagoflex.presupuesto.controller;

import com.pagoflex.presupuesto.model.Presupuesto;
import com.pagoflex.presupuesto.service.PresupuestoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/presupuestos")
@RequiredArgsConstructor
public class PresupuestoController {

    private final PresupuestoService presupuestoService;

    @GetMapping
    public List<Presupuesto> listar() {
        return presupuestoService.listar();
    }

    @GetMapping("/{id}")
    public Presupuesto obtener(@PathVariable Long id) {
        return presupuestoService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Presupuesto> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return presupuestoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Presupuesto guardar(@RequestBody Presupuesto presupuesto) {
        return presupuestoService.guardar(presupuesto);
    }

    @PutMapping("/{id}")
    public Presupuesto actualizar(
            @PathVariable Long id,
            @RequestBody Presupuesto presupuesto) {

        return presupuestoService.actualizar(id, presupuesto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        presupuestoService.eliminar(id);
    }
}
