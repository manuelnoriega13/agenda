package com.manoriega.agenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class TestFoo {


    @Bean(name = "x")
    public String getFoo312312(){
        return new String("foosdfsdfnaskdfnaskdfnasdmfs,dfmsdfm,dfansmdfsdfasd");
    }

    @Bean(name = "z")
    public String zxc(){
        return new String("zxc");
    }


}
