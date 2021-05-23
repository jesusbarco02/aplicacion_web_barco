package com.salesianostriana.primerodam.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.primerodam.proyecto.modelo.Bicicleta;
import com.salesianostriana.primerodam.proyecto.modelo.DataMaster;
import com.salesianostriana.primerodam.proyecto.servicios.BicicletaServicio;
import com.salesianostriana.primerodam.proyecto.servicios.CategoriaServicio;

import lombok.RequiredArgsConstructor;

/**
 * Controlador del objeto Bicicleta, donde podremos utilizar los métodos que
 * hemos creado en BaseService y devolviendo el resultado en plantilla HTML
 * 
 * @author Jesús Barco
 *
 */
@Controller
@RequiredArgsConstructor
public class BicicletaController {

	private final BicicletaServicio bicicletaServicio;
	private final CategoriaServicio categoriaServicio;

	/**
	 * Método que nos atiende la petición de la página principal, donde podremos
	 * realizar la función de buscarte mediante el fabricante con el método que
	 * hemos creado anteriormente
	 * 
	 * @param model
	 * @param consulta
	 * @return Devuelve la plantilla HTML donde pintaremos de manera dinámicante los
	 *         datos
	 */

	@GetMapping({ "/", "/bicicletas" })
	public String index(Model model, @RequestParam("q") Optional<String> consulta) {

		List<Bicicleta> bicicletas;
		model.addAttribute("categorias", categoriaServicio.findAll());

		if (consulta.isEmpty()) {

			bicicletas = bicicletaServicio.findAll();
		} else {
			bicicletas = bicicletaServicio.buscarPorFabricante(consulta.get());
		}

		model.addAttribute("bicicletaList", bicicletas);
		return "index";
	}

	/**
	 * Método donde pedimos la petición de que nos muestre la página principal
	 * utilizando el método que muestre las bicicletas de un solo tipo
	 * 
	 * @param model
	 * @param id
	 * @return Devuelve página principal con las bicicletas del tipo que le hemos
	 *         indicado
	 */
	@GetMapping("/bicicletas/categoria/{id}")
	public String bicicletaFabricante(Model model, @PathVariable("id") Long id) {

		model.addAttribute("categorias", categoriaServicio.findAll());

		model.addAttribute("bicicletaList", bicicletaServicio.todosLasBicicletasDeUnTipo(id));

		return "index";
	}
	

	/**
	 * Añadir una nueva bicicleta, usará un formulario por lo que, como todos los
	 * formularios necesitará dos métodos: Uno para atender la petición get (mostrar
	 * el formulario en blanco) y otro para post (recoger los datos de los campos y
	 * procesar esa información)
	 * 
	 * @param model
	 * @return Devuelve la plantilla del formulario con los campos sin rellenar
	 */

	@GetMapping("/agregarBicicleta")
	public String agregar(Model model) {

		model.addAttribute("categorias", categoriaServicio.findAll());
		model.addAttribute("bicicleta", new Bicicleta());

		return "formulario";
	}

	/**
	 * Este segundo método ha "recogido" un parámetro del formulario, en este caso,
	 * una bicicleta (formada por todos los campos del form).
	 * 
	 * @param bicicleta Bicicleta que guardamos
	 * @return
	 */
	@PostMapping("/agregarBicicleta/submit")
	public String processForm(@ModelAttribute("bicicleta") Bicicleta bicicleta) {

		bicicletaServicio.save(bicicleta);

		return "redirect:/";
	}

	/**
	 * Editar bicicleta, editaremos los campos que veamos necesario mediante el
	 * formulario, y se cambiarán los datos cambiados.
	 * 
	 * @param id
	 * @param model
	 * @return Devuelve la plantilla del formulario con los campos rellenos
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {

		Bicicleta bicicleta = bicicletaServicio.findById(id).orElse(null);
		model.addAttribute("categorias", categoriaServicio.findAll());

		model.addAttribute("bicicleta", bicicleta);
		return "formulario";
	}

	/**
	 * Método que nos borra el elemento que indiquemos mediante su identicador
	 * 
	 * @param id
	 * @param model
	 * @return Nos redirije a la página principal
	 */

	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Bicicleta bicicleta = bicicletaServicio.findById(id).orElse(null);

		if (bicicleta != null) {
			bicicletaServicio.deleteById(id);
		}

		return "redirect:/";

	}

	/**
	 * Método para mostrar los detalles de un producto en concreto, nos lo muestra
	 * pasándole su identificador
	 * 
	 * @param id
	 * @param model
	 * @return Nos devuelve la plantilla 'detalles', con la información de ese
	 *         prodcuto más detallada
	 */

	@GetMapping("/bicicleta/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {

		// Buscamos el producto por id
		Bicicleta b = bicicletaServicio.findById(id).orElse(null);
		// Si el producto no es null (si existe el producto buscado) se añade al modelo
		// y mostramos la página del detalle detail.html
		// Si no existe, volvemos a la página index que vuelve a realizar todo lo que
		// hace el método index
		if (b != null) {
			model.addAttribute("bicicleta", b);
			return "detalles";
		}

		return "redirect:/";

	}

	/**
	 * Lista los géneros que hemos introducido en una lista en la clase DataMaster
	 * 
	 * @return Devuelve el método que hemos creado en la clase DataMaster con los
	 *         géneros
	 */
	@ModelAttribute("generos")
	public List<String> generos() {
		return DataMaster.generos();
	}

	/**
	 * Lista los tamaños que hemos introducido en una lista en la clase DataMaster
	 * 
	 * @return Devuelve el método que hemos creado en la clase DataMaster con los
	 *         tamaños
	 */
	@ModelAttribute("tamanios")
	public List<Integer> tamanios() {
		return DataMaster.tamRueda();
	}

	/**
	 * Lista todas las categorías
	 * 
	 * @return Devuelve una lista con las diferentes categorías
	 */
	@ModelAttribute("categorias")
	public List<Bicicleta> categorias() {
		return bicicletaServicio.findAll();
	}

}
