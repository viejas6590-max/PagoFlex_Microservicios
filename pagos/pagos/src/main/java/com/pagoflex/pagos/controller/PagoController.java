package com.pagoflex.pagos.controller;

import com.pagoflex.pagos.model.Pago;
import com.pagoflex.pagos.service.PagoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
@RequiredArgsConstructor
public class PagoController {

    private final PagoService pagoService;

    @GetMapping
    public List<Pago> listar() {
        return pagoService.listar();
    }

    @GetMapping("/{id}")
    public Pago obtener(@PathVariable Long id) {
        return pagoService.obtener(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Pago> listarPorUsuario(
            @PathVariable Long usuarioId) {
        return pagoService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/suscripcion/{suscripcionId}")
    public List<Pago> listarPorSuscripcion(
            @PathVariable Long suscripcionId) {
        return pagoService.listarPorSuscripcion(suscripcionId);
    }

    @PostMapping
    public Pago guardar(@RequestBody Pago pago) {
        return pagoService.guardar(pago);
    }

    @PutMapping("/{id}")
    public Pago actualizar(
            @PathVariable Long id,
            @RequestBody Pago pago) {

        return pagoService.actualizar(id, pago);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pagoService.eliminar(id);
    }
}
