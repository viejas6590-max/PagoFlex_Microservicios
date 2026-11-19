package com.pagoflex.categorias.repository;

import com.pagoflex.categorias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository
        extends JpaRepository<Categoria, Long> {

    Optional<Categoria> findByNombre(String nombre);
}
