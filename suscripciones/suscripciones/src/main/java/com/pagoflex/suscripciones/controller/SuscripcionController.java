package com.pagoflex.suscripciones.controller;

import com.pagoflex.suscripciones.model.Suscripcion;
import com.pagoflex.suscripciones.service.SuscripcionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/suscripciones")
@RequiredArgsConstructor
public class SuscripcionController {

    private final SuscripcionService suscripcionService;

    @GetMapping
    public List<Suscripcion> listar() {
        return suscripcionService.listar();
    }

    @GetMapping("/{id}")
    public Suscripcion obtener(@PathVariable Long id) {
        return suscripcionService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Suscripcion> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return suscripcionService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Suscripcion guardar(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.guardar(suscripcion);
    }

    @PutMapping("/{id}")
    public Suscripcion actualizar(
            @PathVariable Long id,
            @RequestBody Suscripcion suscripcion) {

        return suscripcionService.actualizar(id, suscripcion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        suscripcionService.eliminar(id);
    }
}
