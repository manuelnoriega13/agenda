package com.manoriega.agenda.service;

import com.manoriega.agenda.dao.*;
import com.manoriega.agenda.entities.Direccion;
import com.manoriega.agenda.entities.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private IDireccionDao direccionDao;

    @Autowired
    private IEmailDao emailDao;

    @Autowired
    private IPersonaDao personaDao;

    @Autowired
    private ITelefonoDao telefonoDao;

    @Autowired
    private ITelefonoTipoDao telefonoTipoDao;


    public Persona create(Persona persona) {
        personaDao.save(persona);
        return persona;

    }
}
