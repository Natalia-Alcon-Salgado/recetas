package org.proyect.controller.web;

import java.util.List;

import org.proyect.domain.Juego;
import org.proyect.domain.Pelicula;
import org.proyect.domain.Usuario;
import org.proyect.exception.DangerException;
import org.proyect.helper.ComentarioValidator;
import org.proyect.helper.EmailValidator;
import org.proyect.helper.H;
import org.proyect.helper.PRG;
import org.proyect.service.JuegoService;
import org.proyect.service.PeliculaService;
import org.proyect.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private PeliculaService peliculaService;
	@Autowired
	private JuegoService juegoService;
	@Autowired
	private JavaMailSender javaMailSender;

	@GetMapping("/")
	public String home(ModelMap m) {
		// Obtiene todos los juegos y los añade al modelo
		List<Juego> juegos = juegoService.findAll();
		int cantidadMaximaJuegos = 4;
		m.put("juegos", juegos);
		m.addAttribute("cantidadMaximaJuegos", cantidadMaximaJuegos);

		List<Pelicula> peliculas = peliculaService.findAll();
		int cantidadMaximaPeliculas = 4;
		m.put("peliculas", peliculas);
		m.addAttribute("cantidadMaximaPeliculas", cantidadMaximaPeliculas);

		// Agrega las películas para el carrusel
		m.put("carouselPeliculas", peliculas.subList(0, Math.min(5, peliculas.size())));
		m.put("carouselJuegos", juegos.subList(0, Math.min(4, juegos.size())));

		m.put("view", "home/home");
		return "_t/frame";
	}

	@GetMapping("/info")
	public String info(HttpSession s, ModelMap m) {

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

	@GetMapping("/init")
	public String crearAdmin() {
		usuarioService.save("admin", "admin", null);
		usuarioService.setAdmin("-1");
		return "redirect:/";
	}

	@GetMapping("/login")
	public String login(
			ModelMap m) {
		m.put("view", "home/login");
		return "_t/frame";
	}

	@PostMapping("/login")
	public String loginPost(
			@RequestParam("email") String email,
			@RequestParam("pass") String password,
			HttpSession s,
			ModelMap m) throws DangerException {
		try {
			// Validar el formato del correo electrónico
			if (!EmailValidator.isValidEmail(email)) {
				PRG.error("Formato de correo electrónico no válido");
			}
			if (!ComentarioValidator.validarComentario(email)) {
				PRG.error("El email tiene palabras prohibidas", "/");
			}
			if (!ComentarioValidator.validarComentario(password)) {
				PRG.error("La contraseña tiene palabras prohibidas", "/");
			}

			Usuario usuario = usuarioService.login(email, password);
			usuarioService.setRegistro(email);
			s.setAttribute("usuario", usuario);
			s.setAttribute("nombre", email);

		} catch (DangerException e) {
			throw e; // Re-lanzar excepciones DangerException para que se manejen adecuadamente
		} catch (Exception e) {
			PRG.error("Error inesperado al iniciar sesión", "/");
		}
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession s) {
		String nombre = (String) s.getAttribute("nombre");
		usuarioService.setLogout(nombre);
		s.invalidate();
		return "redirect:/";
	}

	@GetMapping("/sn")
	public String sn(ModelMap m) {
		m.put("view", "home/sn");
		return "_t/frame";
	}

	@GetMapping("/politica")
	public String politica(ModelMap m) {
		m.put("view", "home/politica");
		return "_t/frame";
	}

	@GetMapping("/contacto")
	public String contacto(ModelMap m, HttpSession session) {
		if (H.isRolOk("auth", session)) {
			Usuario usuario = (Usuario) session.getAttribute("usuario");

			// Verificar si el usuario existe y tiene películas favoritas
			if (usuario != null) {
				m.put("usuario", usuario);
			}
			m.put("view", "home/contacto");
			return "_t/frame";
		}
		return "redirect:/";

	}

	@PostMapping("/contacto")
	public String contactoPost(
			@RequestParam("tema") String tema,
			@RequestParam("contenido") String contenido,
			ModelMap m, HttpSession session) throws DangerException {

		Usuario usuario = (Usuario) session.getAttribute("usuario");
		if (!ComentarioValidator.validarComentario(contenido)) {
			PRG.error("El comentario no puede estar vacío o tiene palabras prohibidas", "redirect:/");
		}
		sendEmail(usuario.getCorreo(), tema, "Datos del usuario👤 \n" + "----------------------\n" +
				"Nombre: " + usuario.getNombre() + "\n" + "Correo📧: " + usuario.getCorreo() + "\n"
				+ "----------------------\n" + "Detalles de la incidencia🔍 \n"
				+ "----------------------\n" + contenido);
		m.put("view", "home/contacto");
		return "_t/frame";
	}

	public void sendEmail(String emailTo, String subject, String content) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("pelijuegosdanaca33@gmail.com");
		message.setSubject(subject);
		message.setText(content);
		message.setFrom(emailTo);

		javaMailSender.send(message);
		System.out.println("Correo enviado exitosamente");
	}
}