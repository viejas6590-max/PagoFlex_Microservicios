package com.pagoflex.usuarios.service;

import com.pagoflex.usuarios.client.RolClient;
import com.pagoflex.usuarios.dto.*;
import com.pagoflex.usuarios.model.Usuario;
import com.pagoflex.usuarios.repository.UsuarioRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private static final Long ROL_USUARIO = 2L;

    private final UsuarioRepository usuarioRepository;
    private final RolClient rolClient;

    public List<UsuarioResponse> listar() {

        return usuarioRepository.findAll()
                .stream()
                .map(this::convertirRespuesta)
                .toList();
    }

    public UsuarioResponse obtener(Long id) {

        Usuario usuario = buscar(id);

        return convertirRespuesta(usuario);
    }

    public UsuarioResponse registrar(RegistroRequest datos) {

        if (usuarioRepository.existsByCorreo(datos.correo())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El correo ya está registrado"
            );
        }

        Long rolId = datos.rolId() != null
                ? datos.rolId()
                : ROL_USUARIO;

        validarRol(rolId);

        Usuario usuario = Usuario.builder()
                .nombre(datos.nombre())
                .correo(datos.correo())
                .contrasena(datos.contrasena())
                .ciudad(datos.ciudad())
                .rolId(rolId)
                .build();

        return convertirRespuesta(
                usuarioRepository.save(usuario)
        );
    }

    public UsuarioResponse iniciarSesion(LoginRequest datos) {

        Usuario usuario = usuarioRepository
                .findByCorreo(datos.correo())
                .filter(u -> u.getContrasena()
                        .equals(datos.contrasena()))
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.UNAUTHORIZED,
                                "Correo o contraseña incorrectos"
                        )
                );

        return convertirRespuesta(usuario);
    }

    public UsuarioResponse actualizar(
            Long id,
            ActualizarUsuarioRequest datos) {

        Usuario usuario = buscar(id);

        if (usuarioRepository.existsByCorreoAndIdNot(
                datos.correo(), id)) {

            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "El correo ya está registrado"
            );
        }

        usuario.setNombre(datos.nombre());
        usuario.setCorreo(datos.correo());
        usuario.setCiudad(datos.ciudad());

        return convertirRespuesta(
                usuarioRepository.save(usuario)
        );
    }

    public void cambiarContrasena(
            Long id,
            CambiarContrasenaRequest datos) {

        Usuario usuario = buscar(id);

        if (!usuario.getContrasena().equals(datos.actual())) {
            throw new ResponseStatusException(
                    HttpStatus.UNAUTHORIZED,
                    "La contraseña actual es incorrecta"
            );
        }

        usuario.setContrasena(datos.nueva());

        usuarioRepository.save(usuario);
    }

    public void eliminar(Long id) {

        Usuario usuario = buscar(id);

        usuarioRepository.delete(usuario);
    }

    private Usuario buscar(Long id) {

        return usuarioRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Usuario no encontrado"
                        )
                );
    }

    private void validarRol(Long rolId) {

        if (rolClient.obtener(rolId) == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "El rol indicado no existe"
            );
        }
    }

    private UsuarioResponse convertirRespuesta(Usuario usuario) {

        RolDto rol = rolClient.obtener(usuario.getRolId());

        return new UsuarioResponse(
                usuario.getId(),
                usuario.getNombre(),
                usuario.getCorreo(),
                usuario.getCiudad(),
                usuario.getRolId(),
                rol.nombre()
        );
    }
}
