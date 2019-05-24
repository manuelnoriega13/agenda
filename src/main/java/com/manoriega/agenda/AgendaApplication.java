package com.manoriega.agenda;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@EnableEncryptableProperties
@SpringBootApplication
public class AgendaApplication {


    public static void main(String[] args) {
        SpringApplication.run(AgendaApplication.class, args);

    }

//    @Value("${j}")
    private String pro;

    @Component
    public class myRunner implements CommandLineRunner{
        @Override
        public void run(String... args) throws Exception {
            System.out.println(pro);

        }
    }


}
