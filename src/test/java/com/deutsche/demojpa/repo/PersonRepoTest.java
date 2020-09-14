package com.deutsche.demojpa.repo;

import com.deutsche.demojpa.model.Address;
import com.deutsche.demojpa.model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class PersonRepoTest {

    @Autowired
    private PersonRepo personRepo;




    @BeforeEach
    @Transactional
    @Rollback(false)
    public void setUp(String str) {


        Optional.ofNullable(str).map(String::length);

        personRepo.save(Person.builder().name("Vasya").address(Address.builder().city("Vasya").build()).build());
    }

    @Test
    @Transactional
    public void onlyVasyaPerson() {
        List<Person> people = personRepo.onlyVasyaPerson();
        Assert.assertEquals(1,people.size());
    }
}













