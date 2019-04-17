package com.manoriega.agenda.controller;

import com.manoriega.agenda.dao.IPersonaDao;
import com.manoriega.agenda.entities.Direccion;
import com.manoriega.agenda.entities.Persona;
import com.manoriega.agenda.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(PersonaApiController.HEAD)
public class PersonaApiController {
    public static final String HEAD = "/api/persona";
    public static final String CREATE = "/create";
    public static final String LIST = "/list";
    public static final String DELETE = "/delete/{id}";
    public static final String DELETE_ALL = "/deleteall";
    public static final String UPDATE = "/update/{id}";
    public static final String BYID = "/byid/{id}";

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private PersonaService personaService;

    @PostMapping(PersonaApiController.CREATE)
    public Persona create(@RequestBody Persona persona) {
        return personaDao.save(persona);
    }

    @GetMapping(PersonaApiController.LIST)
    public List<Persona> personaList() {
        return personaDao.findAll();
    }

    @DeleteMapping(PersonaApiController.DELETE)
    public Boolean delete(@PathVariable Long id) {
        Optional<Persona> persona = personaDao.findById(id);
        if (persona.isPresent()) {
            personaDao.delete(persona.get());
            return persona.isPresent();
        } else return false;
    }

    @DeleteMapping(PersonaApiController.DELETE_ALL)
    public Boolean deleteAll() {
        Boolean resultado = (personaDao.count() > 1) ? true : false;
        if (resultado) {
            personaDao.deleteAll();
            return true;
        } else return false;
    }

    @PutMapping(PersonaApiController.UPDATE)
    public Persona update(@RequestBody Persona newPersona, @PathVariable Long id) {
        return personaDao.findById(id).map(persona -> {
            persona.setPrimerNombre(newPersona.getPrimerNombre());
//            persona.setPrimerApellido(newPersona.getPrimerApellido());
            return personaDao.save(persona);
        }).orElseGet(() -> {
            newPersona.setId(id);
            return personaDao.save(newPersona);
        });
    }

    @GetMapping(PersonaApiController.BYID)
    public Optional<Persona> getById(Long id){
        return personaDao.findById(id);
    }

}
