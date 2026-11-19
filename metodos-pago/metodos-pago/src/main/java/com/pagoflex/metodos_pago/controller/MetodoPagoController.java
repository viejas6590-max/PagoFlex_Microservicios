package com.pagoflex.metodos_pago.controller;

import com.pagoflex.metodos_pago.model.MetodoPago;
import com.pagoflex.metodos_pago.service.MetodoPagoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/metodos-pago")
@RequiredArgsConstructor
public class MetodoPagoController {

    private final MetodoPagoService metodoPagoService;

    @GetMapping
    public List<MetodoPago> listar() {
        return metodoPagoService.listar();
    }

    @GetMapping("/{id}")
    public MetodoPago obtener(@PathVariable Long id) {
        return metodoPagoService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<MetodoPago> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return metodoPagoService.listarPorUsuario(usuarioId);
    }

    @PostMapping
    public MetodoPago guardar(@RequestBody MetodoPago metodoPago) {
        return metodoPagoService.guardar(metodoPago);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(
            @PathVariable Long id,
            @RequestBody MetodoPago metodoPago) {

        return metodoPagoService.actualizar(id, metodoPago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        metodoPagoService.eliminar(id);
    }
}
