package com.salesianostriana.primerodam.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**
 * Clase Categoría donde tenemos la asociación uno a muchos con la clase bicicleta. En esta clase guardaremos los diferentes tipos de la clase bicicleta.
 * @author Jesús Barco
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private long id;

	private String tipo;
	
	/**
	 * Creamos el contructor con un solo parámetro
	 * @param tipo String indicando el tipo de categoría
	 */

	public Categoria(String tipo) {
		super();
		this.tipo = tipo;
	}

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "categoria", fetch = FetchType.EAGER)
	private List<Bicicleta> bicicletas = new ArrayList<>();

	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade a
	 * una bicicleta a la colección de bicicletas de una catego´ria, y asigna a dicha bicicleta esta
	 * categoría como la suya.
	 * 
	 * @param b Objeto bicicleta 
	 */
	public void addBicicleta(Bicicleta b) {
		this.bicicletas.add(b);
		b.setCategoria(this);
	}

	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina
	 * una bicicleta de la colección de bicicletas de una categoría, y desasigna a dicha bicicleta
	 * la categoría, dejándolo como nulo.
	 * 
	 * @param b
	 */
	public void removeBicicleta(Bicicleta b) {
		this.bicicletas.remove(b);
		b.setCategoria(null);
	}

	@Override
	public String toString() {
		return  tipo ;
	}
	
	
	
	

}
