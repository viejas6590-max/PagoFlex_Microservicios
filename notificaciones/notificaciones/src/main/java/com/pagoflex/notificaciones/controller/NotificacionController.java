package com.pagoflex.notificaciones.controller;

import com.pagoflex.notificaciones.model.Notificacion;
import com.pagoflex.notificaciones.service.NotificacionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notificaciones")
@RequiredArgsConstructor
public class NotificacionController {

    private final NotificacionService notificacionService;

    @GetMapping
    public List<Notificacion> listar() {
        return notificacionService.listar();
    }

    @GetMapping("/{id}")
    public Notificacion obtener(@PathVariable Long id) {
        return notificacionService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Notificacion> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return notificacionService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public Notificacion guardar(@RequestBody Notificacion notificacion) {
        return notificacionService.guardar(notificacion);
    }

    @PutMapping("/{id}")
    public Notificacion actualizar(
            @PathVariable Long id,
            @RequestBody Notificacion notificacion) {

        return notificacionService.actualizar(id, notificacion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        notificacionService.eliminar(id);
    }
}
