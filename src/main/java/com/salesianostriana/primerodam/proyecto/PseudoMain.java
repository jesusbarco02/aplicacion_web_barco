package com.salesianostriana.primerodam.proyecto;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.salesianostriana.primerodam.proyecto.modelo.Bicicleta;
import com.salesianostriana.primerodam.proyecto.modelo.Categoria;
import com.salesianostriana.primerodam.proyecto.servicios.BicicletaServicio;
import com.salesianostriana.primerodam.proyecto.servicios.CategoriaServicio;

import lombok.RequiredArgsConstructor;

/**
 * La función de esta clase sería donde instanciamos los diferentes datos de nuestras clases.
 * @author Jesús Barco
 *
 */
@Component
@RequiredArgsConstructor
public class PseudoMain {

	private final BicicletaServicio bicicletaServicio;
	private final CategoriaServicio categoriaServicio;
	
	/**
	 * Método donde introducimos los datos iniciales que deseamos que contenga nuestro proyecto
	 */

	@PostConstruct
	public void init() {

		List<Categoria> categorias = List.of(new Categoria("Bicicleta de montaña"),
				new Categoria("Bicicleta de carretera"), new Categoria("Bicicleta eléctrica"),
				new Categoria("Bicicleta para niños"), new Categoria("Bicicleta de paseo"));

		categorias.forEach(categoriaServicio::save);

		Bicicleta b1 = new Bicicleta("Marin", "Marin Bobcat Trail 4","Masculino","Alumnio", 14.69, 27,
				"Marin 31.8 Riser","La Bobcat Trail es una moto de alto rendimiento con una geometría moderna.","https://images.internetstores.de/products//1057361/02/2769d8/Marin_Bobcat_Trail_4_27_5__gloss_crimson_teal_red[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true", 749,
				categoriaServicio.findById(1L).get());
		Bicicleta b2 = new Bicicleta("Votec","VRC Evo","Unisex","Carbono",8.5,27,"ZIPP ServiceCourse SL","Rompe las reglas. Redefine tu comprensión de una perfecta ronda después del trabajo. No importa cuándo o dónde te sientes en tu Votec VRC. No tienes que comprometerte cuando se trata del terreno.","https://images.internetstores.de/products//1225449/02/372fe5/VOTEC_VRC_Evo_mat_black[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",3999,categoriaServicio.findById(2L).get());
		Bicicleta b3= new Bicicleta ("Serious","Valparola Comp","Unisex","Aluminio",10.85,27,"FSA HB-RD320","Con la Valparola Comp para principiantes, las verdaderas virtudes de la competición son posibles incluso sin un presupuesto de cuatro dígitos. Su nombre proviene del pintoresco paso de Valparola (2192 m) en las Dolomitas italianas.","https://images.internetstores.de/products//1284291/02/050588/1284291_22bf78_jpg[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",999, categoriaServicio.findById(2L).get());
		Bicicleta b5 = new Bicicleta ("Vermont","Race 12","Masculino","Acero",9.61,12,"FSA","La bicicleta para niños convence sobre todo a los padres por su calidad y sus detalles útiles. Los niños están entusiasmados con el aspecto salvaje de la bicicleta. Además de un cuadro de acceso bajo, la bicicleta infantil Vermont tiene llantas de aluminio resistentes.","https://images.internetstores.de/products//1175141/02/9e4bf8/Vermont_Race_12__Kinder_black[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",139.99,categoriaServicio.findById(4L).get());
		Bicicleta b4 = new Bicicleta ("Haibike","XDURO AllMtn","Unisex","Aluminio",23.5,27,"Riser","Con su robusto equipamiento y el nuevo sistema FLYON ePerformance, el XDURO AllMtn 5.0 está dirigido a todos los pilotos que quieran experimentar un ePerformance completo en las subidas y en las bajadas.","https://images.internetstores.de/products//1079258/02/0eeacb/HAIBIKE_XDURO_AllMtn_5_0_white_blue_orange[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",5999,categoriaServicio.findById(3L).get());
		Bicicleta b6 = new Bicicleta ("Tern","Link C8","Unisex","Aluminio",14.77,20,"Ris","La Link C8 cuenta con nuestra principal tecnología. Una bici con un precio increíble y altas prestaciones a la hora de rodar. Con tecnología de plegado única, desarrollo versátil y cubiertas confortables.","https://images.internetstores.de/products//875118/02/5ece1b/tern_Link_C8_20__blue[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",849,categoriaServicio.findById(5L).get());
		Bicicleta b7 = new Bicicleta ("Kona","Process X","Masculino","Carbono",15.09,27,"Kona XC/BC","El nuevo Proceso X ha sido mejorado de nuevo para el 2021. Esta máquina hambrienta de gravedad tiene un recorrido de muelle delantero de 170 mm y un recorrido de muelle trasero de 161 mm. Con su marco completo de carbono, su distancia entre ejes ajustable y la opción de montar una rueda trasera de 29 o 27,5, el Process X puede ser perfectamente ajustado.","https://images.internetstores.de/products//1279980/02/dfa8fc/Kona_Process_X_gloss_metallic_black[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",5999,categoriaServicio.findById(1L).get());
		Bicicleta b8 = new Bicicleta ("Orbea","Rise M10","Unisex","Carbono",18.05,29,"Riser","La Rise te aporta esa sensación especial en la que menos E significa más moto. Tanto si quieres recorrer distancias más largas, llegar a lugares épicos, simplemente ser más eficiente en la carretera o vivir grandes aventuras con más frecuencia.","https://images.internetstores.de/products//1342581/02/bc101d/Orbea_Rise_M10_sap_white_green_fog[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",7999,categoriaServicio.findById(3L).get());
		Bicicleta b9 = new Bicicleta ("Serious","Superhero","Femenino","Acero",8.72,12,"ISER","Serious sabe exactamente lo que los pequeños ciclistas quieren. Con la Serious Superhero, los jóvenes ciclistas de montaña también son tomados en serio. Incluso el grupo de ruedas de apoyo de 16 pulgadas puede sentarse aquí en una bicicleta todo terreno.","https://images.internetstores.de/products//1132070/02/687f52/Serious_Superhero_16__Kinder_white[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",199.99,categoriaServicio.findById(4L).get());
		Bicicleta b10 = new Bicicleta ("Tern","Verge D9","Unisex","Aluminio",13.72,20,"ISER","Especialmente en las grandes ciudades, la bicicleta ya no es sólo un dispositivo de ocio o deportivo, sino simplemente el mejor medio de transporte para distancias cortas. La Verge D9 es uno de los modelos utilizados allí. Por qué? Porque ofrece el máximo valor por el ahorro.","https://images.internetstores.de/products//565595/02/53f63e/tern_Verge_D9_20__gunmetal_green[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",949,categoriaServicio.findById(5L).get());
		Bicicleta b11 = new Bicicleta ("Ghost","Lector","Unisex","Carbono",15.72,27,"URRSER","Esta bici tiene el ADN de GHOST en forma pura. Extremadamente ligera, extremadamente rígida, extremadamente mordaz y, por supuesto, extremadamente rápida. Esta bici está diseñada para la competición y tanto si estás compitiendo en la competición internacional como si quieres ganar un nuevo PB en tu vuelta de entrenamiento.","https://images.internetstores.de/products//1055894/02/838473/Ghost_Lector_1_6_LC_26__riot_red_jet_black[640x480].jpg?forceSize=true&forceAspectRatio=true&useTrim=true",1499,categoriaServicio.findById(1L).get());

		
		bicicletaServicio.save(b1);
		bicicletaServicio.save(b2);
		bicicletaServicio.save(b3);
		bicicletaServicio.save(b4);
		bicicletaServicio.save(b5);
		bicicletaServicio.save(b6);
		bicicletaServicio.save(b7);
		bicicletaServicio.save(b8);
		bicicletaServicio.save(b9);
		bicicletaServicio.save(b10);
		bicicletaServicio.save(b11);


	}

}
