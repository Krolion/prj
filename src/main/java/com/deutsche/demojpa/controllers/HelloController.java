package com.deutsche.demojpa.controllers;

import com.deutsche.demojpa.model.Address;
import com.deutsche.demojpa.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Evgeny Borisov
 */
@RestController
@RequestMapping("/api/")
public class HelloController {


    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        Person person = Person.builder().address(Address.builder().city("Leningrad").street("бутлерова").build()).name("vasya").build();
        String json = mapper.writeValueAsString(person);
        Person person1 = mapper.readValue(json, Person.class);
        System.out.println("json = " + json);
        System.out.println("person1 = " + person1);
        System.out.println(person.equals(person1));
    }

    @PostMapping("pp")
    public Person incrementAge(@RequestBody Person person) {
        return person.withAge(person.getAge() + 1);
    }


    @PutMapping(value = "person")
    public Person person(){
        return Person.builder().address(Address.builder().city("Leningrad").street("бутлерова").build()).name("Jack").age(20).build();
    }

    @GetMapping("all")
    public String hello4(HttpServletRequest request) {
        return "all";
    }


    @GetMapping("hi")
    public String hello3(@RequestParam String name, @RequestParam int age){
        return "hi "+name.toUpperCase()+ age;
    }

    @GetMapping("hello/{name}")
    public String hello2(@PathVariable String name){
        return name.toUpperCase();
    }

    @GetMapping("hello")
    public String hello(){
        return "hello";
    }
}





