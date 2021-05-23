package com.salesianostriana.primerodam.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.primerodam.proyecto.modelo.Bicicleta;

/**
 * Clase repositorio del objeto Bicicleta
 * 
 * @author Jesús Barco
 *
 */
public interface BicicletaRepositorio extends JpaRepository<Bicicleta, Long> {

	/**
	 * Devuelve una lista ordenada por el fabricante que le pasemos por parámetro
	 * 
	 * @param fabricante String que le pasamos para que se realice la búsqueda
	 *                   mediante ese String
	 */

	List<Bicicleta> findByFabricanteContainsIgnoreCaseOrderByFabricanteAsc(String fabricante);

	/**
	 * Devuelve una lista ordenada por la categoría mediante el identificador que le
	 * pasamos por parámetros
	 * 
	 * @param id Identificador de ese objeto
	 */

	List<Bicicleta> findByCategoriaIdOrderByFabricanteAsc(Long id);

}
