package com.pagoflex.notificaciones.service;

import com.pagoflex.notificaciones.model.Notificacion;
import com.pagoflex.notificaciones.repository.NotificacionRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificacionService {

    private final NotificacionRepository notificacionRepository;

    public List<Notificacion> listar() {
        return notificacionRepository.findAll();
    }

    public Notificacion obtener(Long id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Notificación no encontrada"));
    }

    public List<Notificacion> listarPorUsuario(Long usuarioId) {
        return notificacionRepository.findByUsuarioId(usuarioId);
    }

    public Notificacion guardar(Notificacion notificacion) {
        return notificacionRepository.save(notificacion);
    }

    public Notificacion actualizar(Long id, Notificacion datos) {

        Notificacion notificacion = obtener(id);

        notificacion.setUsuarioId(datos.getUsuarioId());
        notificacion.setTitulo(datos.getTitulo());
        notificacion.setMensaje(datos.getMensaje());
        notificacion.setFecha(datos.getFecha());
        notificacion.setEstadoLeida(datos.getEstadoLeida());

        return notificacionRepository.save(notificacion);
    }

    public void eliminar(Long id) {

        Notificacion notificacion = obtener(id);

        notificacionRepository.delete(notificacion);
    }
}