package com.salesianostriana.primerodam.proyecto.servicios;

import java.util.List;
import org.springframework.stereotype.Service;
import com.salesianostriana.primerodam.proyecto.modelo.Bicicleta;
import com.salesianostriana.primerodam.proyecto.repositorio.BicicletaRepositorio;
import com.salesianostriana.primerodam.proyecto.servicios.base.BaseService;

/**
 * Clase donde extiende del BaseService que ya hemos creado con los métodos que
 * vamos a utilizar.
 * 
 * @author Jesús Barco
 *
 */

@Service
public class BicicletaServicio extends BaseService<Bicicleta, Long, BicicletaRepositorio> {

	/**
	 * Método que busca por el atributo fabricante de la clase Bicicleta
	 * 
	 * @param b String que indica el fabricante por que deseamos buscar
	 * @return Devuelve una lista ordenada con el nombre del fabricante que hemos
	 *         indicado
	 */
	public List<Bicicleta> buscarPorFabricante(String b) {
		return this.repositorio.findByFabricanteContainsIgnoreCaseOrderByFabricanteAsc(b);
	}

	/**
	 * Método que nos muestra todas las bicicletas de un mismo tipo de la clase
	 * categoría
	 * 
	 * @param id Identificador del tipo que queremos buscar
	 * @return Devuelve una lista del objeto que pertenezca al id que le pasamos
	 *         como parámetro
	 */
	public List<Bicicleta> todosLasBicicletasDeUnTipo(Long id) {
		return this.repositorio.findByCategoriaIdOrderByFabricanteAsc(id);
	}

}
