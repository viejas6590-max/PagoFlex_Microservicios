package com.pagoflex.usuarios.dto;

public record RegistroRequest(
        String nombre,
        String correo,
        String contrasena,
        String ciudad,
        Long rolId
) {
}
