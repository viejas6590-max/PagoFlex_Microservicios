package com.pagoflex.categorias.service;

import com.pagoflex.categorias.model.Categoria;
import com.pagoflex.categorias.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    public Categoria obtener(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoría no encontrada"));
    }

    public Categoria guardar(Categoria categoria) {

        if (categoriaRepository.findByNombre(categoria.getNombre()).isPresent()) {
            throw new RuntimeException("La categoría ya existe");
        }

        return categoriaRepository.save(categoria);
    }

    public Categoria actualizar(Long id, Categoria datos) {

        Categoria categoria = obtener(id);

        categoria.setNombre(datos.getNombre());
        categoria.setDescripcion(datos.getDescripcion());

        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {

        Categoria categoria = obtener(id);

        categoriaRepository.delete(categoria);
    }
}
