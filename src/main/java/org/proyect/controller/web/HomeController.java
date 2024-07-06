package org.proyect.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	// MÉTODO PARA QUE VAYA A LA VISTA DEL HOME ASOCIÁNDOLE UNA URI
	@GetMapping("/")
	// LE PASAMOS LA RUTA DE LA VISTA PIDIÉNDOSELO A SPRING
	public String home(ModelMap m) {
		// DESDE CUALQUIER PUNTO DEL CÓDIGO LLAMAREMOS A t/frame PARA QUE DESPLEGUE
		// VISTAS
		m.put("view", "home/home");
		return "_t/frame";
	}

	@GetMapping("/info")
	public String info(
			HttpSession s,
			ModelMap m) {
		String mensaje = s.getAttribute("_mensaje") != null ? (String) s.getAttribute("_mensaje")
				: "Pulsa para volver a home";
		String severity = s.getAttribute("_severity") != null ? (String) s.getAttribute("_severity") : "info";
		String link = s.getAttribute("_link") != null ? (String) s.getAttribute("_link") : "/";

		s.removeAttribute("_mensaje");
		s.removeAttribute("_severity");
		s.removeAttribute("_link");

		m.put("mensaje", mensaje);
		m.put("severity", severity);
		m.put("link", link);

		m.put("view", "/_t/info");
		return "/_t/frame";
	}
}