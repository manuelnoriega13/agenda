package com.manoriega.agenda;

import com.manoriega.agenda.dao.IPersonaDao;
import com.manoriega.agenda.entities.Direccion;
import com.manoriega.agenda.entities.Persona;
import com.manoriega.agenda.service.TestFoo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaApplicationTests {

    @Autowired
    private TestFoo testFoo;

    @Autowired
    @Qualifier("z")
    private String foo;

    @Autowired
    @Qualifier("x")
    private String foo2;

    @Autowired
    private IPersonaDao personaDao;

    @Test

    public void contextLoads() {
        Persona persona = Persona.builder()
                .primerNombre("manuel")
                .segundoNombre("alejandro")
                .primerApellido("noriega")
                .segundoApellido("zabala")
                .fechaNacimiento(new Date(87,9,13))
                .activo(true)
                .build();

//        personaDao.save(persona);
        List<Persona> personaList = personaDao.findAll();
    }


}
