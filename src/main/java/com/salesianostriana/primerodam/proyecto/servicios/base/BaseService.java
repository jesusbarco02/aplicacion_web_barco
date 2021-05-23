package com.salesianostriana.primerodam.proyecto.servicios.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Esta clase extiende de JpaRepository, en el cuál se encuentra los métodos siguientes que vamos a utilizar.
 * @author Jesús Barco
 *
 * @param <T>
 * @param <ID>
 * @param <R>
 */
public abstract class BaseService<T, ID, R extends JpaRepository<T, ID>> {

	@Autowired
	protected R repositorio;
	
	/**
	 * Método guardar, donde podremos guardar el objeto
	 * @param t 
	 * @return Llamamos al método guardar del repositorio
	 */

	public T save(T t) {
		return repositorio.save(t);
	}
	/**
	 * Método editar, donde podremos editar el objeto
	 * @param t
	 * @return Llamamos al método que nos facilita el repositorio
	 */
	public T edit(T t) {
		return save(t);
	}
	
	/**
	 * Método borrar, se borrará el objeto que le pasemos como parámetro
	 * @param t Objeto que deseamos borrar
	 */
	
	public void delete(T t) {
		repositorio.delete(t);
		
	}
	
	/**
	 * Método borrar mediante Id y nos borrará el objeto que tenga como el mismo Id que le pasemos como parámetro
	 * @param id Identificador del objeto que deseamos borrar
	 */
	
	public void deleteById(ID id) {
		repositorio.deleteById(id);
	}
	/**
	 * Método que nos busca todos los elementos que se encuentre en una lista.
	 * @return
	 */
	
	public List<T> findAll() {
		return repositorio.findAll();
	}
	/**
	 * Método que nos busca mediante el parámetro que le pasemos como identificador
	 * @param id Parámetro que le pasamos por el cuál deseamos que realice la búsqueda
	 * @return Devuelve el objeto que perteneza a ese parámetro que le hemos pasado
	 */
	public Optional<T> findById(ID id) {
		return repositorio.findById(id);
	}
	
	
	


}
