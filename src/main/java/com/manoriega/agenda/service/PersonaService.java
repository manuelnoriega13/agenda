package com.manoriega.agenda.service;

import com.manoriega.agenda.dao.*;
import com.manoriega.agenda.dto.DireccionDTO;
import com.manoriega.agenda.dto.EmailDTO;
import com.manoriega.agenda.dto.PersonaDTO;
import com.manoriega.agenda.dto.TelefonoDTO;
import com.manoriega.agenda.entities.Direccion;
import com.manoriega.agenda.entities.Email;
import com.manoriega.agenda.entities.Persona;
import com.manoriega.agenda.entities.Telefono;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class PersonaService {

    @Autowired
    private IPersonaDao personaDao;


    public Persona create(Persona persona) {
        personaDao.save(persona);
        return persona;
    }

    public Optional<PersonaDTO> byId(Long id) {
        Optional<Persona> persona = personaDao.findById(id);
        PersonaDTO personaDTO = PersonaDTO.builder()
                .id(persona.get().getId())
                .direccionDTOList(persona.get().getDireccionList().stream().map(direccion -> {
                    DireccionDTO direccionDTO = DireccionDTO.builder().id(direccion.getId())
                            .pais(direccion.getPais())
                            .estado(direccion.getEstado())
                            .ciudad(direccion.getCiudad())
                            .calle(direccion.getCalle())
                            .numero(direccion.getNumero())
                            .piso(direccion.getPiso())
                            .departamento(direccion.getDepartamento())
                            .principal(direccion.getPrincipal())
                            .build();
                    return direccionDTO;
                }).collect(Collectors.toList()))
                .emailDTOSet(persona.get().getEmailSet().stream().map(email -> {
                    EmailDTO emailDTO = EmailDTO.builder()
                            .id(email.getId())
                            .email(email.getEmail())
                            .build();
                    return emailDTO;
                }).collect(Collectors.toSet()))
                .telefonoDTOSet(persona.get().getTelefonoSet().stream().map(telefono -> {
                    TelefonoDTO telefonoDTO = TelefonoDTO.builder()
                            .id(telefono.getId())
                            .telefono(telefono.getTelefono())
                            .build();
                    return telefonoDTO;
                }).collect(Collectors.toSet()))
                .build();
        return Optional.ofNullable(personaDTO);
    }

    public List<PersonaDTO> personaDTOList() {
        List<PersonaDTO> personaDTOList = personaDao.findAll()
                .stream()
                .map(persona -> {
                    PersonaDTO personaDTO = PersonaDTO.builder()
                            .id(persona.getId())
                            .primerNombre(persona.getPrimerNombre())
                            .segundoNombre(persona.getSegundoNombre())
                            .primerApellido(persona.getPrimerApellido())
                            .segundoApellido(persona.getSegundoApellido())
                            .fechaNacimiento(persona.getFechaNacimiento())
                            .activo(persona.getActivo())
                            .direccionDTOList(persona.getDireccionList().stream()
                                    .map(direccion -> {
                                        DireccionDTO direccionDTO = DireccionDTO.builder().id(direccion.getId())
                                                .pais(direccion.getPais())
                                                .estado(direccion.getEstado())
                                                .ciudad(direccion.getCiudad())
                                                .calle(direccion.getCalle())
                                                .numero(direccion.getNumero())
                                                .piso(direccion.getPiso())
                                                .departamento(direccion.getDepartamento())
                                                .principal(direccion.getPrincipal())
                                                .build();
                                        return direccionDTO;
                                    }).collect(Collectors.toList()))
                            .telefonoDTOSet(persona.getTelefonoSet().stream().map(telefono -> {
                                TelefonoDTO telefonoDTO = TelefonoDTO.builder()
                                        .id(telefono.getId())
                                        .telefono(telefono.getTelefono())
                                        .build();
                                return telefonoDTO;
                            }).collect(Collectors.toSet()))
                            .emailDTOSet(persona.getEmailSet().stream()
                                    .map(email -> {
                                        EmailDTO emailDTO = EmailDTO.builder()
                                                .id(email.getId())
                                                .email(email.getEmail())
                                                .build();
                                        return emailDTO;
                                    }).collect(Collectors.toSet()))
                            .build();
                    return personaDTO;
                }).collect(Collectors.toList());
        return personaDTOList;
    }

    public Boolean delete(Long id) {
        Optional<Persona> persona = personaDao.findById(id);
        if (persona.isPresent()) {
            personaDao.delete(persona.get());
            return persona.isPresent();
        } else return false;
    }

    public Boolean deleteAll() {
        Boolean resultado = (personaDao.count() > 1) ? true : false;
        if (resultado) {
            personaDao.deleteAll();
            return true;
        } else return false;
    }

    public PersonaDTO update(Persona newPersona, Long id) {
        return personaDao.findById(id).map(persona -> {
            Persona p = Persona.builder()
                    .primerNombre(persona.getPrimerNombre())
                    .segundoNombre(persona.getSegundoNombre())
                    .primerApellido(persona.getPrimerApellido())
                    .segundoApellido(persona.getSegundoApellido())
                    .fechaNacimiento(persona.getFechaNacimiento())
                    .activo(persona.getActivo())
                    .direccionList(persona.getDireccionList().stream().map(direccion -> {
                        Direccion d = Direccion.builder()
                                .id(direccion.getId())
                                .build();
                        return d;
                    }).collect(Collectors.toList()))
                    .telefonoSet(persona.getTelefonoSet().stream().map(telefono -> {
                        Telefono t = Telefono.builder()
                                .id(telefono.getId())
                                .telefono(telefono.getTelefono())
                                .build();
                        return t;
                    }).collect(Collectors.toSet()))
                    .emailSet(persona.getEmailSet().stream().map(email -> {
                        Email e = Email.builder()
                                .id(email.getId())
                                .email(email.getEmail())
                                .build();
                        return e;
                    }).collect(Collectors.toSet()))
                    .build();
            personaDao.save(p);

            PersonaDTO personaDTO = PersonaDTO.builder()
                    .primerNombre(persona.getPrimerNombre())
                    .segundoNombre(persona.getSegundoNombre())
                    .primerApellido(persona.getPrimerApellido())
                    .segundoApellido(persona.getSegundoApellido())
                    .fechaNacimiento(persona.getFechaNacimiento())
                    .activo(persona.getActivo())
                    .build();
            return personaDTO;
        }).orElseGet(() -> {
            newPersona.setId(id);
            personaDao.save(newPersona);

            PersonaDTO personaDTO = PersonaDTO.builder()
                    .primerNombre(newPersona.getPrimerNombre())
                    .segundoNombre(newPersona.getSegundoNombre())
                    .primerApellido(newPersona.getPrimerApellido())
                    .segundoApellido(newPersona.getSegundoApellido())
                    .fechaNacimiento(newPersona.getFechaNacimiento())
                    .activo(newPersona.getActivo())
                    .build();
            return personaDTO;
        });
    }
}
