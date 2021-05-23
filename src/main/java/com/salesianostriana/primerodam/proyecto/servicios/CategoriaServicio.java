package com.salesianostriana.primerodam.proyecto.servicios;

import org.springframework.stereotype.Service;

import com.salesianostriana.primerodam.proyecto.modelo.Categoria;
import com.salesianostriana.primerodam.proyecto.repositorio.CategoriaRepositorio;
import com.salesianostriana.primerodam.proyecto.servicios.base.BaseService;


/**
 * Objeto Categoria extiende de todos los métodos que se encuentran en BaseService
 * @author Jesús Barco
 *
 */
@Service
public class CategoriaServicio extends BaseService<Categoria, Long, CategoriaRepositorio> {

}
