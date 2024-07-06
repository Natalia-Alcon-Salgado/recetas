package org.proyect.controller.web;

import org.proyect.exception.DangerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

    @RequestMapping("/categoria")
    @Controller
    public class CategoriaController {
        // @Autowired
        // // NECESITAMOS UN ATRIBUTO REPOSITORY PARA LA BD
        // private CategoriaService categoriaService;

        // @Autowired
        // // // NECESITAMOS UN ATRIBUTO REPOSITORY DE PAISES
        // private PaisService paisService;

        // @Autowired
        // // // NECESITAMOS UN ATRIBUTO REPOSITORY DE AFICIÓN
        // private AficionService aficionService;

        // // // MÉTODO DE LISTAR CATEGORÍA
        // @GetMapping("r")
        // public String r(ModelMap m) {
        //     // LE PASAMOS LA LISTA DE CATEGORÍAS
        //     m.put("categorias", categoriaService.findAll());

        //     // LE PASAMOS LA VISTA ENMARCADA
        //     m.put("view", "categoria/r");
        //     return "_t/frame";
        // }

        // // // MÉTODO DE CREAR CATEGORÍAS
        // @GetMapping("c")
        // public String c(ModelMap m) {
        //     // Antes de desplegar la vista, le mandamos una vista de categorías
        //     m.put("categorias", categoriaService.findAll());

        //     // VISTA ENMARCADA
        //     m.put("view", "categoria/c");
        //     return "_t/frame";
        // }

        // @PostMapping("c")
        // // // LO QUE PASAMOS POR PARÁMETRO ES LO QUE RECIBE DEL FORMULARIO
        // public String cPost(// OBTENEMOS EL NOMBRE DEL FORMULARIO
        //         @RequestParam("dni") String dni,
        //         @RequestParam("nombre") String nombre,
        //         @RequestParam("id-nace") Long idNace,
        //         @RequestParam("id-vive") Long idVive,
        //         @RequestParam(value = "idGusto[]", required = false) List<Long> idsGusto,
        //         @RequestParam(value = "idOdio[]", required = false) List<Long> idsOdio) throws DangerException {

        //     // GUARDAMOS EL NUEVO PAÍS
        //     // ÉSTE NOMBRE VIENE VÍA POST
        //     try {
        //         personaService.save(dni, nombre, idNace, idVive, idsGusto, idsOdio);

        //     } catch (Exception e) {
        //         // Importamos el PRG
        //         PRG.error("La persona con DNI " + dni + " ya existe", "/persona/c");
        //     }
        //     return "redirect:/persona/r";
        // }

        // @GetMapping("u")
        // public String update(@RequestParam("id") Long idPersona, ModelMap m) {
        //     // Le pasamos la persona
        //     m.put("persona", personaService.findById(idPersona));

        //     // Le pasamos los paises
        //     m.put("paises", paisService.findAll());

        //     // Le pasamos las aficiones
        //     m.put("aficiones", aficionService.findAll());

        //     // VISTA ENMARCADA
        //     m.put("view", "persona/u");
        //     return "_t/frame";
        // }

        // @PostMapping("u")
        // public String updatePost(
        //         @RequestParam("idPersona") Long idPersona,
        //         @RequestParam("dni") String dni,
        //         @RequestParam("nombre") String nombre,
        //         @RequestParam("idNace") Long idNace,
        //         @RequestParam("idVive") Long idVive,
        //         @RequestParam(value = "idGusto[]", required = false) List<Long> idsGusto,
        //         @RequestParam(value = "idOdio[]", required = false) List<Long> idsOdio)
        //         throws DangerException {

        //     try {
        //         personaService.update(idPersona, dni, nombre, idNace, idVive, idsGusto, idsOdio);
        //     } catch (Exception e) {
        //         PRG.error("La persona no se actualizó ", "persona/r");
        //     }
        //     return "redirect:/persona/r";
        // }

        // // Método D
        // @PostMapping("d")
        // public String delete(
        //         @RequestParam("id") Long idPersona) throws DangerException {
        //     try {
        //         personaService.delete(idPersona);
        //     } catch (Exception e) {
        //         PRG.error(e.getMessage(), "/persona/r");
        //     }
        //     return "redirect:/persona/r";
        // }
    }