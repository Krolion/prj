package com.deutsche.demojpa;

import com.deutsche.demojpa.services.PersonService;
import com.github.javafaker.Faker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.deutsche.demojpa.repo")
public class DemoJpaApplication {



    @Bean
    public Faker faker(){
        return new Faker();
    }



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoJpaApplication.class, args);
//        PersonService personService = context.getBean(PersonService.class);
//        personService.save10Person();
//        personService.printAllYoungPersons();
//        System.out.println();
    }

}
