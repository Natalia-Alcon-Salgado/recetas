package org.proyect.service;

import org.springframework.stereotype.Service;


@Service
public class CategoriaService {
    // @Autowired
    // private PersonaRepository personaRepository;

    // @Autowired
    // private PaisRepository paisRepository;

    // @Autowired
    // private AficionRepository aficionRepository;

    // // Hacemos el método que devuelve TODO
    // public List<Persona> findAll() {
    //     return personaRepository.findAll();
    // }

    // // Creamos el método SAVE
    // public void save(String dni, String nombre, Long idNace, Long idVive, List<Long> idsGusto, List<Long> idsOdio) {
    //     Persona persona = new Persona(dni, nombre);

    //     persona.setNace(paisRepository.findById(idNace).get());
    //     persona.setVive(paisRepository.findById(idVive).get());

    //     idsGusto = (idsGusto == null ? new ArrayList<Long>() : idsGusto);

    //     // Recorro mi colección de gustos
    //     for (Long idGusto : idsGusto) {
    //         Aficion gusto = aficionRepository.findById(idGusto).get();
    //         // Le añadimos a esa persona el gusto
    //         persona.getGustos().add(gusto);
    //     }

    //     idsOdio = (idsOdio == null ? new ArrayList<Long>() : idsOdio);

    //     // Recorro mi colección de odios
    //     for (Long idOdio : idsOdio) {
    //         Aficion odio = aficionRepository.findById(idOdio).get();
    //         // Le añadimos a esa persona el gusto
    //         persona.getOdios().add(odio);
    //     }
    //     personaRepository.save(persona);
    // }

    // // Método findId
    // public Persona findById(Long idPersona) {
    //     return personaRepository.findById(idPersona).get();
    // }

    // // Creamos el método UPDATE para actualizar
    // public void update(Long idPersona, String dni, String nombre, Long idNace, Long idVive, List<Long> idsGusto,
    //         List<Long> idsOdio) {
    //     // Obtenemos el nombre del país mal puesto y lo almacenamos
    //     Persona persona = personaRepository.findById(idPersona).get();

    //     // Le pasamos el nuevo dni
    //     persona.setDni(dni);

    //     // Le pasamos el nuevo nombre
    //     persona.setNombre(nombre);

    //     // Actualizamos el nuevo sitio donde nace
    //     persona.setNace(paisRepository.findById(idNace).get());

    //     // Actualizamos el nuevo sitio donde vive
    //     persona.setVive(paisRepository.findById(idVive).get());

    //     idsGusto = (idsGusto == null ? new ArrayList<Long>() : idsGusto);
    //     // Creamos un arrayList nuevo para añadir los nuevos gustos
    //     List<Aficion> nuevosGustos = new ArrayList<Aficion>();

    //     // Recorro mi colección de gustos
    //     for (Long idGusto : idsGusto) {
    //         Aficion gusto = aficionRepository.findById(idGusto).get();
    //         // Le añadimos a esa persona el gusto
    //         nuevosGustos.add(gusto);
    //     }
    //     persona.setGustos(nuevosGustos);

    //     idsOdio = (idsOdio == null ? new ArrayList<Long>() : idsOdio);
    //     // Creamos un arrayList nuevo para añadir los nuevos odios
    //     List<Aficion> nuevosOdios = new ArrayList<Aficion>();

    //     // Recorro mi colección de gustos
    //     for (Long idOdio : idsOdio) {
    //         Aficion odio = aficionRepository.findById(idOdio).get();
    //         // Le añadimos a esa persona el gusto
    //         nuevosOdios.add(odio);
    //     }
    //     persona.setOdios(nuevosOdios);

    //     personaRepository.save(persona);
    // }

    // // Método delete
    // public void delete(Long idPersona) {
    //     personaRepository.delete(personaRepository.getReferenceById(idPersona));
    // }
}