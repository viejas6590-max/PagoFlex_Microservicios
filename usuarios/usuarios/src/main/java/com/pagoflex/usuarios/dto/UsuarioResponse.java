package com.pagoflex.usuarios.dto;

public record UsuarioResponse(
        Long id,
        String nombre,
        String correo,
        String ciudad,
        Long rolId,
        String rolNombre
) {
}