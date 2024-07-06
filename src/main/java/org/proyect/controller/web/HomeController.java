package org.proyect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	/*Hacerlo de cada entidad */
	// @Autowired
	// private UsuarioService usuarioService;

	@GetMapping("/")
	public String home(ModelMap m) {
		// Obtiene todas las recetas y las añade al modelo. Hacerlo de cada entidad
		// List<Juego> juegos = juegoService.findAll();
		// int cantidadMaximaJuegos = 4;
		// m.put("juegos", juegos);
		// m.addAttribute("cantidadMaximaJuegos", cantidadMaximaJuegos);

		m.put("view", "home/home");
		return "_t/frame";
	}
}