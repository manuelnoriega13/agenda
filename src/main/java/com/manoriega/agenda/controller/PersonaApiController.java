package com.manoriega.agenda.controller;

import com.manoriega.agenda.dao.IPersonaDao;
import com.manoriega.agenda.dto.PersonaDTO;
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
        return personaService.create(persona);
    }

    @GetMapping(PersonaApiController.LIST)
    public List<PersonaDTO> personaList() {
        return personaService.personaDTOList();
    }

    @DeleteMapping(PersonaApiController.DELETE)
    public Boolean delete(@PathVariable Long id) {
        return personaService.delete(id);
    }

    @DeleteMapping(PersonaApiController.DELETE_ALL)
    public Boolean deleteAll() {
        return personaService.deleteAll();
    }

    @PutMapping(PersonaApiController.UPDATE)
    public PersonaDTO update(@RequestBody Persona newPersona, @PathVariable Long id) {
        return personaService.update(newPersona, id);
    }

    @GetMapping(PersonaApiController.BYID)
    public Optional<PersonaDTO> getById(Long id) {
        return personaService.byId(id);
    }
}
