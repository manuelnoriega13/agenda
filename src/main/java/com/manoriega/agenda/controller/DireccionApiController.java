package com.manoriega.agenda.controller;

import com.manoriega.agenda.dao.IDireccionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PersonaApiController.HEAD)
public class DireccionApiController {

    public static final String HEAD = "/api/direcion";

    @Autowired
    private IDireccionDao direccionDao;



}
