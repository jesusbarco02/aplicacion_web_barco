package com.salesianostriana.primerodam.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Clase repositorio del objeto Categoría
 *@author Jesús Barco
 */

import com.salesianostriana.primerodam.proyecto.modelo.Categoria;

/**
 * Clase repositorio del objeto Categoría
 * 
 * @author Jesús Barco
 *
 */
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
