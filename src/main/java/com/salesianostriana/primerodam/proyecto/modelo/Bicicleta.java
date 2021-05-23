package com.salesianostriana.primerodam.proyecto.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Creamos el objeto bicicleta, que sería el producto que utilizaremos en
 * nuuestra aplicación
 * 
 * @author Jesús Barco
 *
 */
@Data
@NoArgsConstructor
@Entity
public class Bicicleta {

	@Id
	@GeneratedValue
	private long id;

	private String fabricante;
	private String modeloBicicleta;
	private String genero;
	private String material;
	private double peso;
	private double tamRueda;
	private String modeloManillar;
	@Lob
	private String descripcion;
	private String imagen;
	private double precio;

	@ManyToOne
	private Categoria categoria;

	/**
	 * Creamos el constructor Bicicleta, con todos los atributos excepto el atributo
	 * Id.
	 */

	public Bicicleta(String fabricante, String modeloBicicleta, String genero, String material, double peso,
			double tamRueda, String modeloManillar, String descripcion, String imagen, double precio,
			Categoria categoria) {
		super();
		this.fabricante = fabricante;
		this.modeloBicicleta = modeloBicicleta;
		this.genero = genero;
		this.material = material;
		this.peso = peso;
		this.tamRueda = tamRueda;
		this.modeloManillar = modeloManillar;
		this.descripcion = descripcion;
		this.imagen = imagen;
		this.precio = precio;
		this.categoria = categoria;
	}

}
