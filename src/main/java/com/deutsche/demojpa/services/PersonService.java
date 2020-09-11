package com.deutsche.demojpa.services;

import com.deutsche.demojpa.dao.PersonDao;
import com.deutsche.demojpa.model.Address;
import com.deutsche.demojpa.model.Person;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private Faker faker;


    @Transactional
    public void makePeopleYounger() {
        List<Person> people = personDao.findAll();
        for (Person person : people) {
            person.setAge(person.getAge()-20);
        }
    }


    @Transactional
    public void save10Person() {
        List<Person> people = Stream.iterate(1, i -> ++i)
                .limit(10)
                .map(this::createRandomPerson)
                .collect(Collectors.toList());

        for (Person person : people) {
            personDao.savePerson(person);
        }

        for (Person person : people) {
            person.setName(person.getName().toUpperCase());
        }



    }





    @Transactional
    public void printAllYoungPersons() {
        for (Person person : personDao.findByAgeGreaterThan(18)) {
            System.out.println(person.toString());
        }
    }


    public Person createRandomPerson(int i) {
        return Person.builder().age(i * 5).name(faker.gameOfThrones().character())
                .address(Address.builder().city(faker.address().city()).street(faker.address().streetName()).build())
                .address(Address.builder().city(faker.address().city()).street(faker.address().streetName()).build())
                .build();
    }
}










