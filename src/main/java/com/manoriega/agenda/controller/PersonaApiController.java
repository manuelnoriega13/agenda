package com.manoriega.agenda.controller;

import com.manoriega.agenda.dao.IPersonaDao;
import com.manoriega.agenda.dto.PersonaDTO;
import com.manoriega.agenda.entities.Persona;
import com.manoriega.agenda.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(PersonaApiController.HEAD)
@Validated
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
    public Optional<PersonaDTO> update(@RequestBody Persona newPersona, @PathVariable Long id) {
        Optional<Persona> p = personaDao.findById(id);
        Persona P = p.map(persona -> {
            persona.setActivo(newPersona.getActivo());
            persona.setPrimerNombre(newPersona.getPrimerNombre());
            return persona;
        }).get();
        personaDao.save(p.get());

        PersonaDTO personaDTO = PersonaDTO.builder()
                .activo(P.getActivo())
                .build();

        return Optional.of(personaDTO);

    }

    @GetMapping(PersonaApiController.BYID)
    public Optional<PersonaDTO> getById(@PathVariable Long id) {
        return personaService.byId(id);
    }
}
