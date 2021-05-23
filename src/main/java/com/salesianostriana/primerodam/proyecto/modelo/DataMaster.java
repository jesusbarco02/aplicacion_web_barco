package com.salesianostriana.primerodam.proyecto.modelo;

import java.util.List;

/**
 * Clase donde introducimos datos en algún atributo que necesitamos que siempre
 * se encuentre con las mismas opciones
 * 
 * @author Jesús Barco
 *
 */

public class DataMaster {

	/**
	 * Método que le pasamos una lista de String
	 * 
	 * @return Devuelve una lista de String
	 */
	public static List<String> generos() {
		return List.of("Masculino", "Femenino", "Unisex");
	}

	/**
	 * Método que le pasamos una lista de Integer
	 * 
	 * @return Devuelve lista de Integer
	 */
	public static List<Integer> tamRueda() {
		return List.of(12, 18, 20, 24, 26, 27, 29);
	}

}
