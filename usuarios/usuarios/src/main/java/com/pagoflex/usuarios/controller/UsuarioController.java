package com.pagoflex.usuarios.controller;

import com.pagoflex.usuarios.dto.*;
import com.pagoflex.usuarios.service.UsuarioService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponse> listar() {
        return usuarioService.listar();
    }

    @GetMapping("/{id}")
    public UsuarioResponse obtener(@PathVariable Long id) {
        return usuarioService.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse registrar(
            @RequestBody RegistroRequest datos) {

        return usuarioService.registrar(datos);
    }

    @PostMapping("/login")
    public UsuarioResponse iniciarSesion(
            @RequestBody LoginRequest datos) {

        return usuarioService.iniciarSesion(datos);
    }

    @PutMapping("/{id}")
    public UsuarioResponse actualizar(
            @PathVariable Long id,
            @RequestBody ActualizarUsuarioRequest datos) {

        return usuarioService.actualizar(id, datos);
    }

    @PutMapping("/{id}/contrasena")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cambiarContrasena(
            @PathVariable Long id,
            @RequestBody CambiarContrasenaRequest datos) {

        usuarioService.cambiarContrasena(id, datos);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
    }
}
